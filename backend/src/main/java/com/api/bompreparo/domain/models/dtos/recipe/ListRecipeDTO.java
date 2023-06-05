package com.api.bompreparo.domain.models.dtos.recipe;

import com.api.bompreparo.domain.models.Category;
import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.dtos.category.ListCategoryDTO;
import com.api.bompreparo.domain.models.dtos.image.ImageDTO;
import com.api.bompreparo.domain.models.dtos.user.UserDTO;
import com.api.bompreparo.domain.models.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor
public class ListRecipeDTO {

    private Long recipeId;
    private String name;
    private String description;
    private String preparation;
    private Boolean isPrivate;
    private Difficulty difficulty;
    private ImageDTO image;
    private UserDTO creatorUser;

    public static List<ListRecipeDTO> toListDTO(List<Recipe> recipes) {
        ModelMapper modelMapper = new ModelMapper();

        List<ListRecipeDTO> dtos = recipes
                .stream()
                .map(x -> modelMapper.map(x, ListRecipeDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

}
