package com.api.bompreparo.domain.models.dtos.recipe;

import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.dtos.recipeIngredient.RecipeIngredientDTO;
import com.api.bompreparo.domain.models.Category;
import com.api.bompreparo.domain.models.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

@Data @NoArgsConstructor @AllArgsConstructor
public class CreateRecipeDTO {

    private String name;
    private String description;
    private String preparation;
    private Boolean isPrivate;
    private List<Category> categories;
    private Difficulty difficulty;
    private List<RecipeIngredientDTO> recipeIngredients;
    private Image image;

    public static CreateRecipeDTO toDTO(Recipe recipe) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper.map(recipe, CreateRecipeDTO.class);
    }

}
