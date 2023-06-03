package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "ingredient")
public class IngredientController {

    @Autowired
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestBody Ingredient obj) {
        try {
            ingredientService.create(obj);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/read")
    public ResponseEntity<Object> read(@RequestParam(value = "id") UUID id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(ingredientService.read(id));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Object> update(@RequestBody Ingredient obj) {
        try {
            ingredientService.update(obj);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam(value = "id") UUID id) {
        try {
            ingredientService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list")
    public ResponseEntity<Object> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientService.list());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

    @PostMapping(value = "/create-ingredient")
    public ResponseEntity<Object> createIngredient(@RequestBody Ingredient ingredient) {
        try {
            ingredientService.createIngredient(ingredient);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/get-ingredient")
    public ResponseEntity<Object> getIngredient(@RequestParam(value = "ingredientId") UUID ingredientId) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(ingredientService.getIngredient(ingredientId));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @PutMapping(value = "/update-ingredient")
    public ResponseEntity<Object> updateIngredient(@RequestBody Ingredient ingredient) {
        try {
            ingredientService.updateIngredient(ingredient);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/delete-ingredient")
    public ResponseEntity<Object> deleteIngredient(@RequestParam(value = "ingredientId") UUID ingredientId) {
        try {
            ingredientService.deleteIngredient(ingredientId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list-ingredients")
    public ResponseEntity<Object> listIngredients() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientService.listIngredients());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/list-ingredients-by-user")
    public ResponseEntity<Object> listIngredientsByUser(@RequestParam(value = "userId") UUID userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientService.listIngredientsByUser(userId));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

}
