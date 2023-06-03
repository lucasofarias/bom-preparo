package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Ingredient;

import java.util.List;
import java.util.UUID;

public interface IngredientService {

    void create(Ingredient obj);
    Ingredient read(UUID id);
    void update(Ingredient obj);
    void delete(UUID id);
    List<Ingredient> list();

    void addIngredientToPantry(UUID ingredientId);
    void createIngredient(Ingredient ingredient);
    Ingredient getIngredient(UUID ingredientId);
    List<Ingredient> listIngredients();
    List<Ingredient> listIngredientsByCurrentUser(); // listar seus ingredientes
    void removeIngredientFromPantry(UUID ingredientId);

}
