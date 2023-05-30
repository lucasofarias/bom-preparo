package com.api.bompreparo.domain.models;

import com.api.bompreparo.domain.models.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String username;
    private String fullName;
    private String email;
    private String cpf;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

}
