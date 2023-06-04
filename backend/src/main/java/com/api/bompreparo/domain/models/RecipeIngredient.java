package com.api.bompreparo.domain.models;

import com.api.bompreparo.domain.models.enums.MeasurementUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "recipes_ingredients")
@Data @NoArgsConstructor @AllArgsConstructor
public class RecipeIngredient {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    @Enumerated(EnumType.STRING)
    private MeasurementUnit measurementUnit;

    private String quantity;
    private Boolean isOptional;

}
