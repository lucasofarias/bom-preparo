package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/recipe")
public class RecipeController {

    @Autowired
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @PostMapping(value = "/create-recipe")
    public ResponseEntity<Object> createRecipe(@RequestBody Recipe recipe) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(recipeService.createRecipe(recipe));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
