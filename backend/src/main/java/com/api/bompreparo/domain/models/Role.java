package com.api.bompreparo.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Role implements GrantedAuthority {

    @Id @GeneratedValue
    private UUID id;
    private String name;

    @Override
    public String getAuthority() {
        return this.name;
    }
}
