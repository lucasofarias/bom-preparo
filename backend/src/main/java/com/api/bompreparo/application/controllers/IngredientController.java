package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.services.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "ingredient")
public class IngredientController {

    @Autowired
    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @Secured({ "ROLE_ADMIN" })
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

    @Secured({ "ROLE_ADMIN" })
    @GetMapping(value = "/read")
    public ResponseEntity<Object> read(@RequestParam(value = "id") Long id) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(ingredientService.read(id));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }

    @Secured({ "ROLE_ADMIN" })
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

    @Secured({ "ROLE_ADMIN" })
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Object> delete(@RequestParam(value = "id") Long id) {
        try {
            ingredientService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @Secured({ "ROLE_ADMIN" })
    @GetMapping(value = "/list")
    public ResponseEntity<Object> list() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientService.list());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

    @PostMapping(value = "/add-ingredient-to-pantry")
    public ResponseEntity<Object> addIngredientToPantry(@RequestBody Long ingredientId) {
        try {
            ingredientService.addIngredientToPantry(ingredientId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
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
    public ResponseEntity<Object> getIngredient(@RequestParam(value = "ingredientId") Long ingredientId) {
        try {
            return ResponseEntity.status(HttpStatus.FOUND).body(ingredientService.getIngredient(ingredientId));
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
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

    @GetMapping(value = "/list-ingredients-by-current-user")
    public ResponseEntity<Object> listIngredientsByCurrentUser() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(ingredientService.listIngredientsByCurrentUser());
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/remove-ingredient-from-pantry")
    public ResponseEntity<Object> removeIngredientFromPantry(@RequestBody Long ingredientId) {
        try {
            ingredientService.removeIngredientFromPantry(ingredientId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
