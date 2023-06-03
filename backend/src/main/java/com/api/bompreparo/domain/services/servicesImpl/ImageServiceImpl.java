package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.application.util.ImageUtil;
import com.api.bompreparo.data.repositories.ImageRepository;
import com.api.bompreparo.data.repositories.RecipeRepository;
import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private final ImageRepository imageRepository;

    @Autowired
    private final RecipeRepository recipeRepository;

    public ImageServiceImpl(ImageRepository imageRepository, RecipeRepository recipeRepository) {
        this.imageRepository = imageRepository;
        this.recipeRepository = recipeRepository;
    }

    @Override
    public void create(MultipartFile obj, UUID recipeId) throws IOException {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("Receita não encontrada."));

        Image image = imageRepository.save(Image.builder()
                .type(obj.getContentType())
                .data(ImageUtil.compressImage(obj.getBytes()))
                .recipe(recipe).build());
    }

    @Override
    public void delete(UUID id) {

    }

    @Override
    public void uploadImage(MultipartFile imageFile, UUID recipeId) throws IOException {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("A receita não foi encontrada."));

        Image image = imageRepository.save(Image.builder()
                .type(imageFile.getContentType())
                .data(ImageUtil.compressImage(imageFile.getBytes()))
                .recipe(recipe).build());

        if (image == null) {
            throw new IllegalArgumentException("Ocorreu um erro ao salvar a imagem.");
        }
    }

    @Override
    public void deleteImage(UUID imageId) {
        imageRepository.findById(imageId)
                        .orElseThrow(() -> new IllegalArgumentException("A imagem não foi encontrada."));

        imageRepository.deleteById(imageId);
    }

}
