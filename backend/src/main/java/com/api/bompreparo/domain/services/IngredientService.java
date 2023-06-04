package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Ingredient;

import java.util.List;

public interface IngredientService {

    void create(Ingredient obj);
    Ingredient read(Long id);
    void update(Ingredient obj);
    void delete(Long id);
    List<Ingredient> list();

    void addIngredientToPantry(Long ingredientId);
    void createIngredient(Ingredient ingredient);
    Ingredient getIngredient(Long ingredientId);
    List<Ingredient> listIngredients();
    List<Ingredient> listIngredientsByCurrentUser();
    void removeIngredientFromPantry(Long ingredientId);

}
