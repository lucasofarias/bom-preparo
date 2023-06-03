package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.Ingredient;

import java.util.List;
import java.util.UUID;

public interface IngredientService {

    Ingredient create(Ingredient obj);
    Ingredient read(UUID id);
    void update(Ingredient obj);
    void delete(UUID id);
    List<Ingredient> list();

    void createIngredient(Ingredient ingredient);
    void deleteIngredient(UUID ingredientId);
    List<Ingredient> listIngredients();
    List<Ingredient> listIngredientsByUser(UUID userId); // listar seus ingredientes
    Ingredient getIngredient(UUID ingredientId);
    void updateIngredient(Ingredient ingredient);

}
