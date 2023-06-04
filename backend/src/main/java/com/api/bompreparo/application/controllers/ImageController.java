package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @Secured({ "ROLE_ADMIN" })
    @PostMapping(value = "/create")
    public ResponseEntity<Object> create(@RequestParam(value = "obj") MultipartFile obj, @RequestParam(value = "id") Long id) {
        try {
            this.imageService.create(obj, id);
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
            this.imageService.delete(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @PostMapping(value = "/upload-image")
    public ResponseEntity<Object> uploadImage(@RequestParam(value = "imageFile") MultipartFile imageFile, @RequestParam(value = "recipeId") Long recipeId) {
        try {
            this.imageService.uploadImage(imageFile, recipeId);
            return ResponseEntity.status(HttpStatus.OK).body("A imagem foi salva com sucesso.");
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/delete-image")
    public ResponseEntity<Object> deleteImage(@RequestParam(value = "imageId") Long imageId) {
        try {
            this.imageService.deleteImage(imageId);
            return ResponseEntity.status(HttpStatus.OK).build();
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
