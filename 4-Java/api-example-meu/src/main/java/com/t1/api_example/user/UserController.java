package com.t1.api_example.user;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.Map;

@RestController
@Tag(name = "Users")
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal User u){
        var user = userRepository.findByUsername(u.getUsername()).orElseThrow();

        return Map.of(
                "id", user.getId(),
                "name",user.getName(),
                "username",user.getUsername(),
                "roles",user.getRoles()
        );

    }

}
