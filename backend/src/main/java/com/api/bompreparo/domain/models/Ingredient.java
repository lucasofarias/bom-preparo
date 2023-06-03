package com.api.bompreparo.domain.models;

import jakarta.persistence.*;
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

    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creatorUser;

}
