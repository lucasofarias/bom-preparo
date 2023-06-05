package com.api.bompreparo.domain.models.dtos.category;

import com.api.bompreparo.domain.models.Category;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.models.dtos.recipe.ListRecipeDTO;
import com.api.bompreparo.domain.models.dtos.user.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor
public class CategoryDTO {

    private Long categoryId;
    private String name;
    private List<ListRecipeDTO> recipes;

    public static CategoryDTO toDTO(Category category) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper.map(category, CategoryDTO.class);
    }

    public static List<CategoryDTO> toListDTO(List<Category> categories) {
        ModelMapper modelMapper = new ModelMapper();

        List<CategoryDTO> dtos = categories
                .stream()
                .map(x -> modelMapper.map(x, CategoryDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

}
