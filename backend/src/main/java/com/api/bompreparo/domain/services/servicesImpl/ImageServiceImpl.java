package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.ImageRepository;
import com.api.bompreparo.data.repositories.RecipeRepository;
import com.api.bompreparo.domain.models.Image;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void uploadImage(Image image, Long recipeId) {
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("A receita não foi encontrada."));

        Image imageModel = new Image();
        imageModel.setData(image.getData());
        imageModel.setRecipe(recipe);

        imageModel = imageRepository.save(imageModel);

        recipe.setImage(imageModel);

        recipeRepository.save(recipe);
    }

    @Override
    public Image viewImage(Long imageId) {
        return imageRepository.findById(imageId)
                .orElseThrow(() -> new IllegalArgumentException("A imagem não foi encontrada."));
    }

    @Override
    public void deleteImage(Long imageId) {
        Image image = imageRepository.findById(imageId)
                        .orElseThrow(() -> new IllegalArgumentException("A imagem não foi encontrada."));

        Recipe recipe = recipeRepository.findById(image.getRecipe().getId())
                        .orElseThrow(() -> new IllegalArgumentException("A receita não foi encontrada."));

        recipe.setImage(null);
        recipeRepository.save(recipe);

        imageRepository.deleteById(imageId);
    }

}
