package ru.crazy.playground.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class IntBeanTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void beansInitTest() throws Exception {
        var s = mockMvc.perform(get("/int"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var i = Integer.valueOf(s);
        System.out.println(i);
        assertEquals(i.getClass(), Integer.class);
        assertTrue(i != 0);
    }
}
