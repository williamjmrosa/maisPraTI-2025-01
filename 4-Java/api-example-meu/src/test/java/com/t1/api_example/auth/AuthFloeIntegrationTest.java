package com.t1.api_example.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.t1.api_example.auth.dto.RegisterRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class AuthFloeIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void register_login_and_acess_protected_route() throws Exception{
        RegisterRequest register = new RegisterRequest();

        register.setName("Test User");
        register.setUsername("test@example.com");
        register.setPassword("<PASSWORD>");

        MvcResult registerResult = mockMvc.perform(MockMvcRequestBuilders.post("/auth/register").contentType(MediaType.APPLICATION_JSON)
         .content(objectMapper.writeValueAsString(register)))
                .andExpect(status().isCreated())
                .andExpect((ResultMatcher) jsonPath("$.token").exists())
                .andReturn();

        String tokenFromRegister = objectMapper.readTree(registerResult.getResponse().getContentAsString()).get("token").asText();
        MvcResult meResult = mockMvc.perform(get("/user/me").header("Authorization", "Bearer " + tokenFromRegister))
                .andReturn();


    }

}
