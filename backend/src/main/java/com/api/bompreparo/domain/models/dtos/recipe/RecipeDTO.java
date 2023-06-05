package com.api.bompreparo.domain.models.dtos.recipe;

import com.api.bompreparo.domain.models.*;
import com.api.bompreparo.domain.models.dtos.category.CategoryDTO;
import com.api.bompreparo.domain.models.dtos.category.ListCategoryDTO;
import com.api.bompreparo.domain.models.dtos.image.ImageDTO;
import com.api.bompreparo.domain.models.dtos.recipeIngredient.RecipeIngredientDTO;
import com.api.bompreparo.domain.models.dtos.user.UserDTO;
import com.api.bompreparo.domain.models.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor
public class RecipeDTO {

    private Long recipeId;
    private String name;
    private String description;
    private String preparation;
    private Boolean isPrivate;
    private List<ListCategoryDTO> categories;
    private Difficulty difficulty;
    private List<RecipeIngredientDTO> ingredients;
    private ImageDTO image;
    private UserDTO creatorUser;

    public static RecipeDTO toDTO(Recipe recipe) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper.map(recipe, RecipeDTO.class);
    }

    public static List<RecipeDTO> toListDTO(List<Recipe> recipes) {
        ModelMapper modelMapper = new ModelMapper();

        List<RecipeDTO> dtos = recipes
                .stream()
                .map(x -> modelMapper.map(x, RecipeDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

}
