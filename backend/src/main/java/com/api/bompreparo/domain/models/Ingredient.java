package com.api.bompreparo.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Ingredient {

    @Id @GeneratedValue
    private UUID id;
    private String name;
    private String description;

}
