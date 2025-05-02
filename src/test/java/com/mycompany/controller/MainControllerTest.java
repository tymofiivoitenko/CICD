package com.mycompany.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MainController.class)
public class MainControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void endpointShouldReturnMessage() throws Exception {
        mockMvc.perform(get("/init"))
                .andExpect(status().isOk())
                .andExpect(content().string("Init was done successfully"));
    }

    @Test
    public void mathTest() {
        assertThat(2 + 2).isEqualTo(5);
    }
}
