package com.api.bompreparo.domain.models.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class UpdateUserDTO {

    private Long userId;
    private String username;
    private String email;
    private String password;

}
