package com.api.bompreparo.domain.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data @NoArgsConstructor @AllArgsConstructor
public class UpdateUserDTO {

    private UUID userId;
    private String username;
    private String email;
    private String password;

}
