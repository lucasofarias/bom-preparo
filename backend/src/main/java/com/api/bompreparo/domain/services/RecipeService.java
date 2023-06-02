package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.enums.Category;

import java.util.List;
import java.util.UUID;

public interface RecipeService {

    Recipe create(Recipe obj);
    Recipe read(UUID id);
    void update(Recipe obj);
    void delete(UUID id);
    List<Recipe> list();

    void createRecipe(Recipe recipe);
    Recipe getRecipe(UUID recipeId);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(UUID recipeId);
    List<Recipe> listRecipes();
    List<Recipe> listRecipesByUser(UUID userId);
    List<Recipe> listRecipesByCategory(Category category);

}
