package com.t1.api_example.security;

import com.t1.api_example.user.User;
import com.t1.api_example.user.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException; // Import necessário

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final UserRepository userRepository;
    private final OAuth2AuthorizedClientService clientService;
    private final WebClient webClient;

    public OAuth2LoginSuccessHandler(JwtService jwtService, UserRepository userRepository,
                                     OAuth2AuthorizedClientService clientService, WebClient webClient) {
        this.jwtService = jwtService;
        this.userRepository = userRepository;
        this.clientService = clientService;
        this.webClient = webClient;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        OAuth2User oAuth2User = (OAuth2User) authentication.getPrincipal();
        String usernameGitHub = oAuth2User.getAttribute("login");
        String email = oAuth2User.getAttribute("email");
        String name = oAuth2User.getAttribute("name");

        // 1. Tenta obter o e-mail se a primeira tentativa falhar (email privado no GitHub)
        if (email == null) {
            email = fetchEmailFromGitHub(authentication);
        }

        // 2. Define o nome de usuário (username) do nosso sistema como o email, ou usa um fallback seguro
        // O username será o email. Se for nulo, usamos o login do GitHub com um sufixo temporário.
        String finalUsername = email != null ? email : usernameGitHub + "@github.temp";

        // 3. Encontra ou cria o usuário
        User user = userRepository.findByUsername(finalUsername)
                .orElseGet(() -> {
                    User newUser = new User();
                    newUser.setUsername(finalUsername);
                    newUser.setName(name != null ? name : usernameGitHub);
                    newUser.setPassword(null); // Sem senha para login OAuth2
                    newUser.setRoles(Collections.singleton("USER")); // Define um Set com o papel "USER"
                    return userRepository.save(newUser);
                });

        // 4. Geração do Token e Redirecionamento
        Map<String, Object> claims = Map.of(
                "name", user.getName(),
                "roles", user.getRoles()
        );
        String token = jwtService.generateToken(user.getUsername(), claims);
        String redirectUrl = "/auth/oauth2/success?token=" + token;

        getRedirectStrategy().sendRedirect(request, response, redirectUrl);
    }

    // Método que busca o e-mail primário e verificado na API do GitHub
    private String fetchEmailFromGitHub(Authentication authentication) {
        if (!(authentication instanceof OAuth2AuthenticationToken)) {
            return null;
        }

        OAuth2AuthenticationToken oauthToken = (OAuth2AuthenticationToken) authentication;

        OAuth2AuthorizedClient authorizedClient = clientService.loadAuthorizedClient(
                oauthToken.getAuthorizedClientRegistrationId(),
                oauthToken.getName());

        if (authorizedClient == null || authorizedClient.getAccessToken() == null) {
            return null;
        }

        String accessToken = authorizedClient.getAccessToken().getTokenValue();

        try {
            // Chama a API do GitHub para obter a lista de e-mails
            List<Map<String, Object>> emails = webClient.get()
                    .uri("https://api.github.com/user/emails")
                    .header("Authorization", "Bearer " + accessToken)
                    .retrieve()
                    // Adicione onStatus para capturar o erro HTTP e debugá-lo
                    .onStatus(status -> status.is4xxClientError() || status.is5xxServerError(),
                            response -> response.createException().map(e -> {
                                System.err.println("ERRO GITHUB API (" + response.statusCode() + "): Falha ao buscar emails.");
                                System.err.println("Detalhe do erro: " + e.getResponseBodyAsString());
                                return e;
                            }))
                    .bodyToMono(List.class)
                    .block(); // Bloqueia a execução para obter o resultado

            if (emails == null) {
                return null;
            }

            // Itera sobre a lista para encontrar o e-mail primário e verificado
            for (Map<String, Object> emailData : emails) {
                Boolean primary = (Boolean) emailData.get("primary");
                Boolean verified = (Boolean) emailData.get("verified");
                String email = (String) emailData.get("email");

                if (primary != null && primary && verified != null && verified && email != null) {
                    return email; // Retorna o e-mail primário e verificado
                }
            }
        } catch (WebClientResponseException e) {
            // Este catch captura exceções de resposta HTTP (4xx, 5xx)
            System.err.println("ERRO FATAL NA CHAMADA WEBCIENT: " + e.getResponseBodyAsString());
        } catch (Exception e) {
            // Captura outras exceções (como problemas de serialização)
            System.err.println("ERRO DESCONHECIDO NO WEBCIENT: " + e.getMessage());
        }
        return null; // Nenhum e-mail primário e verificado encontrado ou a chamada falhou
    }
}