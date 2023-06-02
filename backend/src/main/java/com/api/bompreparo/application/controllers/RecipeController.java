package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.enums.Category;
import com.api.bompreparo.domain.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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
            recipeService.createRecipe(recipe);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/delete-recipe")
    public ResponseEntity<Object> deleteRecipe(@RequestParam(value = "recipeId") UUID recipeId) {
        try {
            recipeService.deleteRecipe(recipeId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list-recipes")
    public ResponseEntity<Object> listRecipes() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(recipeService.listRecipes());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list-recipes-by-user")
    public ResponseEntity<Object> listRecipesByUser(@RequestParam(value = "userId") UUID userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(recipeService.listRecipesByUser(userId));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list-recipes-by-category")
    public ResponseEntity<Object> listRecipesByCategory(@RequestParam(value = "category") Category category) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(recipeService.listRecipesByCategory(category));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/get-recipe")
    public ResponseEntity<Object> getRecipe(@RequestParam(value = "recipeId") UUID recipeId) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(recipeService.getRecipe(recipeId));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping(value = "/update-recipe")
    public ResponseEntity<Object> updateRecipe(@RequestBody Recipe recipe) {
        try {
            recipeService.updateRecipe(recipe);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
