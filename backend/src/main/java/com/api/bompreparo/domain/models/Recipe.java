package com.api.bompreparo.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Recipe {

    @Id @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private String preparation;
    private boolean isPrivate;

    @OneToMany(mappedBy = "recipe")
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creatorUser;

}
