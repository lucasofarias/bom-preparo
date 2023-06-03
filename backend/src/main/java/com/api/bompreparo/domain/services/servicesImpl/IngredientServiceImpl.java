package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.services.IngredientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Override
    public Ingredient create(Ingredient obj) {
        return null;
    }

    @Override
    public Ingredient read(UUID id) {
        return null;
    }

    @Override
    public void update(Ingredient obj) {

    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public List<Ingredient> list() {
        return null;
    }

    @Override
    public void createIngredient(Ingredient ingredient) {

    }

    @Override
    public void deleteIngredient(UUID ingredientId) {

    }

    @Override
    public List<Ingredient> listIngredients() {
        return null;
    }

    @Override
    public List<Ingredient> listIngredientsByUser(UUID userId) {
        return null;
    }

    @Override
    public Ingredient getIngredient(UUID ingredientId) {
        return null;
    }

    @Override
    public void updateIngredient(Ingredient ingredient) {

    }

}
