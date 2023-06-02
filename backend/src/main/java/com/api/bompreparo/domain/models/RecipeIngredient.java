package com.api.bompreparo.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "recipes_ingredients")
@Data @NoArgsConstructor @AllArgsConstructor
public class RecipeIngredient {

    @Id @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    private Recipe recipe;

    @ManyToOne
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;

    private String quantity;

    @OneToOne
    @JoinColumn(name = "measurement_unit_id")
    private MeasurementUnit measurementUnit;

}
