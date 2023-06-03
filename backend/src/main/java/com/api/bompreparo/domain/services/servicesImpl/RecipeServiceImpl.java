package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.RecipeRepository;
import com.api.bompreparo.data.repositories.UserRepository;
import com.api.bompreparo.domain.models.Recipe;
import com.api.bompreparo.domain.models.User;
import com.api.bompreparo.domain.models.enums.Category;
import com.api.bompreparo.domain.services.RecipeService;
import com.api.bompreparo.domain.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private final RecipeRepository recipeRepository;

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final UserService userService;

    public RecipeServiceImpl(RecipeRepository recipeRepository, UserRepository userRepository, UserService userService) {
        this.recipeRepository = recipeRepository;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Recipe create(Recipe obj) {
        return recipeRepository.save(obj);
    }

    @Override
    public Recipe read(UUID id) {
        return recipeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID não encontrado."));
    }

    @Override
    public void update(Recipe obj) {
        recipeRepository.save(obj);
    }

    @Override
    public void delete(UUID id) {
        recipeRepository.deleteById(id);
    }

    @Override
    public List<Recipe> list() {
        return recipeRepository.findAll();
    }

    @Override
    @Transactional
    public void createRecipe(Recipe recipe) {
        if (recipe.getName().trim().isEmpty() || recipe.getDescription().trim().isEmpty()
                || recipe.getPreparation().trim().isEmpty() || recipe.getCategory() == null
                || recipe.getDifficulty() == null || recipe.getIngredients().isEmpty()
                || recipe.getIsPrivate().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        Recipe recipeModel = new Recipe();

        recipeModel.setName(recipe.getName());
        recipeModel.setDescription(recipe.getDescription());
        recipeModel.setPreparation(recipe.getPreparation());
        recipeModel.setIsPrivate(recipe.getIsPrivate());
        recipeModel.setIngredients(recipe.getIngredients());
        recipeModel.setCategory(recipe.getCategory());
        recipeModel.setDifficulty(recipe.getDifficulty());
        recipeModel.setImages(recipe.getImages());
        recipeModel.setCreatorUser(this.userService.getCurrentUser());

        recipeRepository.save(recipeModel);
    }

    @Override
    public Recipe getRecipe(UUID recipeId) {
        return recipeRepository.findById(recipeId)
                .orElseThrow(() -> new IllegalArgumentException("A receita não foi encontrada."));
    }

    @Override
    @Transactional
    public void updateRecipe(Recipe recipe) {
        if (recipe.getName().trim().isEmpty() || recipe.getDescription().trim().isEmpty()
                || recipe.getPreparation().trim().isEmpty() || recipe.getCategory().toString().trim().isEmpty()
                || recipe.getDifficulty().toString().trim().isEmpty() || recipe.getIngredients().isEmpty()
                || recipe.getIsPrivate().toString().trim().isEmpty()) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        Recipe recipeModel = this.getRecipe(recipe.getId());

        if (!recipeModel.getCreatorUser().getId().equals(this.userService.getCurrentUser().getId())) {
            throw new IllegalArgumentException("Somente o criador da receita pode alterar ela.");
        }

        recipeModel.setName(recipe.getName());
        recipeModel.setDescription(recipe.getDescription());
        recipeModel.setPreparation(recipe.getPreparation());
        recipeModel.setCategory(recipe.getCategory());
        recipeModel.setDifficulty(recipe.getDifficulty());
        recipeModel.setIngredients(recipe.getIngredients());
        recipeModel.setIsPrivate(recipe.getIsPrivate());

        recipeRepository.save(recipeModel);
    }

    @Override
    @Transactional
    public void deleteRecipe(UUID recipeId) {
        Recipe recipe = this.getRecipe(recipeId);

        if (!recipe.getCreatorUser().getId().equals(this.userService.getCurrentUser().getId())) {
            throw new IllegalArgumentException("Somente o criador da receita pode deletar ela.");
        }

        recipeRepository.delete(recipe);
    }

    @Override
    public List<Recipe> listRecipes() {
        List<Recipe> recipeList = recipeRepository.findAll();

        if (recipeList.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma receita foi encontrada.");
        }

        return recipeList;
    }

    @Override
    public List<Recipe> listRecipesByUser(UUID userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("O usuário não foi encontrado."));

        List<Recipe> recipeList = recipeRepository.findByCreatorUser_Id(userId);

        if (recipeList.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma receita do usuário " + user.getUsername() + " foi encontrada.");
        }

        return recipeList;
    }

    @Override
    public List<Recipe> listRecipesByCategory(Category category) {
        List<Recipe> recipeList = recipeRepository.findByCategory(category);

        if (recipeList.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma receita foi encontrada nessa categoria.");
        }

        return recipeList;
    }

}
