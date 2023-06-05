package com.api.bompreparo.application.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.io.ByteArrayInputStream;

@Configuration
public class JacksonConfig {

    @Autowired
    public void configureJackson(ObjectMapper objectMapper) {
        SimpleModule module = new SimpleModule();
        module.addSerializer(ByteArrayInputStream.class, new ByteArrayInputStreamSerializer());
        objectMapper.registerModule(module);
    }

}
