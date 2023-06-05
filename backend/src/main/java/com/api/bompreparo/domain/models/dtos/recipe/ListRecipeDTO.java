package com.api.bompreparo.domain.models.dtos.recipe;

import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.models.dtos.user.UserDTO;
import com.api.bompreparo.domain.models.enums.Difficulty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor
public class ListRecipeDTO {

    private Long recipeId;
    private String name;
    private String description;
    private String preparation;
    private Boolean isPrivate;
    private Difficulty difficulty;
    private Image image;
    private UserDTO creatorUser;

}
