package com.api.bompreparo.domain.models;

import com.api.bompreparo.domain.models.enums.Category;
import com.api.bompreparo.domain.models.enums.Difficulty;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Recipe {

    @Id @GeneratedValue
    private UUID id;
    private String name;
    private String description;
    private String preparation;
    private Boolean isPrivate;

    @Enumerated(EnumType.STRING)
    private Category category;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    @OneToMany(mappedBy = "recipe", fetch = FetchType.EAGER)
    private List<Image> images;

    @ManyToOne
    @JoinColumn(name = "creator_user_id")
    private User creatorUser;

}
