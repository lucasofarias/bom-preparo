package com.api.bompreparo.application.controllers;

import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.services.ImageService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping(value = "/upload-image")
    public ResponseEntity<Object> uploadImage(@RequestParam(value = "image") MultipartFile imageFile, @RequestParam(value = "recipeId") Long recipeId) throws SerialException, SQLException, IOException {
        byte[] bytes = imageFile.getBytes();
        Blob blob = new javax.sql.rowset.serial.SerialBlob(bytes);

        Image image = new Image();
        image.setData(blob);
        imageService.uploadImage(image, recipeId);

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/view-image")
    public ResponseEntity<Object> viewImage(@RequestParam("imageId") Long imageId) {
        try {
            Image image = imageService.viewImage(imageId);

            byte[] imageBytes = null;
            imageBytes = image.getData().getBytes(1, (int) image.getData().length());

            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imageBytes);
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
