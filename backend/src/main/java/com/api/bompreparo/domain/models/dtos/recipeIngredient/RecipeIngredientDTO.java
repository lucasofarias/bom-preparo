package com.api.bompreparo.domain.models.dtos.recipeIngredient;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.dtos.ingredient.IngredientDTO;
import com.api.bompreparo.domain.models.enums.MeasurementUnit;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class RecipeIngredientDTO {

    private Ingredient ingredient;
    private String quantity;
    private MeasurementUnit measurementUnit;
    private Boolean isOptional;

}
