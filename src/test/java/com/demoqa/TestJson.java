package com.demoqa;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

import domain.JsonParam;


public class TestJson {
    ClassLoader classLoader = TestJson.class.getClassLoader();

    @Test
    void jsonParser() throws Exception {
        InputStream is = classLoader.getResourceAsStream("hobbits.json");
        ObjectMapper objectMapper = new ObjectMapper();
        JsonParam hobbits = objectMapper.readValue(is, JsonParam.class);
        assertThat(hobbits.name).isEqualTo("Frodo");
        assertThat(hobbits.age).isEqualTo(33);
        assertThat(hobbits.friends.name3).contains("Pippin");

    }
}

