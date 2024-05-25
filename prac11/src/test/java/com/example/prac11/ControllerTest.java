package com.example.prac11;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@WebMvcTest
public class ControllerTest {
    @Autowired
    MockMvc mock;

    @Test
    public void hiTest() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/hi")).andExpect(result ->
                Assertions.assertEquals( "privet", result.getResponse().getContentAsString()));
    }
}
