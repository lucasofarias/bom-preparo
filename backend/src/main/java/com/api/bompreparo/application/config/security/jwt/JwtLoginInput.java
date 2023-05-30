package com.api.bompreparo.application.config.security.jwt;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class JwtLoginInput {

    private String username;
    private String password;

}
