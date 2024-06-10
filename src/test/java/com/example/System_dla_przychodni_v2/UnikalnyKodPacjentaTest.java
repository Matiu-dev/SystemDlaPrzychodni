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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UnikalnyKodPacjentaTest {

    private final String CREATE_USER_PATH = "src/test/java/com/example/System_dla_przychodni_v2/" +
            "requests/createUser.json";

    private final String CREATE_UNIKALNY_KOD_PACJENTA_PATH = "src/test/java/com/example/System_dla_przychodni_v2/" +
            "requests/createUnikalneKodyPacjentow.json";

    private final String CREATE_PACJENT_PATH = "src/test/java/com/example/System_dla_przychodni_v2/" +
            "requests/createPacjent.json";

    @Autowired
    private UzytkownikController uzytkownikController;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void userTestController() throws Exception {

        this.mockMvc
                .perform(post("/createPacjent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(readFile(CREATE_PACJENT_PATH)))
                .andDo(print())
                .andExpect(status().isCreated());

        this.mockMvc
                .perform(post("/createUnikalnyKodPacjenta")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(readFile(CREATE_UNIKALNY_KOD_PACJENTA_PATH)))
                .andDo(print())
                .andExpect(status().isCreated());

        this.mockMvc
                .perform(get("/getUnikalnyKodPacjenta/1000"))
                .andDo(print())
                .andExpect(jsonPath("unikalneKodyPacjentow").value("UnikalnyKod"))
                .andExpect(status().isOk());

//        this.mockMvc
//                .perform(delete("/deleteUnikalnyKodPacjenta/1000"))
//                .andDo(print())
//                .andExpect(status().isOk());
//
//        this.mockMvc
//                .perform(delete("/deletePacjent/1000"))
//                .andDo(print())
//                .andExpect(status().isOk());
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
