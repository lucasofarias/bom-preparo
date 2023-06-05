package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.dtos.recipe.CreateRecipeDTO;
import com.api.bompreparo.domain.models.dtos.recipe.ListRecipeDTO;
import com.api.bompreparo.domain.models.dtos.recipe.RecipeDTO;

import java.util.List;

public interface RecipeService {

    void create(Recipe obj);
    Recipe read(Long id);
    void update(Recipe obj);
    void delete(Long id);
    List<Recipe> list();

    void createRecipe(CreateRecipeDTO createRecipeDTO);
    RecipeDTO getRecipe(Long recipeId);
    void updateRecipe(Recipe recipe);
    void deleteRecipe(Long recipeId);
    List<Recipe> listRecipes();
    List<Recipe> listRecipesByCategories(List<Long> categoriesId);
    List<Recipe> listRecipesByCategory(Long categoryId);
    List<RecipeDTO> listRecipesByIngredients(List<Long> ingredientsId);
    List<ListRecipeDTO> listRecipesByUser(Long userId);

}
