package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.RecipeRepository;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private final RecipeRepository recipeRepository;

    public RecipeServiceImpl(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Recipe create(Recipe obj) {
        return null;
    }

    @Override
    public Recipe read(UUID id) {
        return null;
    }

    @Override
    public void update(Recipe obj) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<Recipe> list() {
        return null;
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        return null;
    }

    @Override
    public Recipe getRecipe(UUID recipeId) {
        return null;
    }

    @Override
    public void updateRecipe(Recipe recipe) {

    }

    @Override
    public void deleteRecipe(UUID recipeId) {

    }

    @Override
    public List<Recipe> listRecipes() {
        return null;
    }

}
