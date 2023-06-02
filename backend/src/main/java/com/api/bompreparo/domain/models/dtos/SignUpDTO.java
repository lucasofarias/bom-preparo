package com.api.bompreparo.domain.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class SignUpDTO {

    private String username;
    private String fullName;
    private String email;
    private String cpf;
    private String password;
    private String confirmPassword;

}
