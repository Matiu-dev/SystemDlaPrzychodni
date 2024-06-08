package com.example.System_dla_przychodni_v2;

import com.example.System_dla_przychodni_v2.controller.UzytkownikController;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import static org.springframework.test.web.servlet.MockMvcBuilder.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class UserTest {

    private final String CREATE_USER_PATH = "src/test/java/com/example/System_dla_przychodni_v2/" +
            "requests/createUser.json";

    @Autowired
    private UzytkownikController uzytkownikController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void createUser() throws Exception {

        this.mockMvc
                .perform(post("/createUser")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(readFile(CREATE_USER_PATH)))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    public String readFile(String path) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();

        BufferedReader bufferedReader =
                new BufferedReader(
                        new FileReader(path));

        for(String i = bufferedReader.readLine(); i != null; i = bufferedReader.readLine()) {
            stringBuilder.append(i);
        }

        return stringBuilder.toString();
    }
}
