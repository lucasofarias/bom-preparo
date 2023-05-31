package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.services.ImageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/upload-image")
    public ResponseEntity<Object> uploadImage(@RequestParam(value = "imageFile") MultipartFile imageFile, @RequestParam(value = "recipeId") UUID recipeId) {
        try {
            this.imageService.uploadImage(imageFile, recipeId);
            return ResponseEntity.status(HttpStatus.OK).body("A imagem foi salva com sucesso.");
        }

        catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
        }
    }

}
