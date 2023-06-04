package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.IngredientRepository;
import com.api.bompreparo.data.repositories.UserIngredientRepository;
import com.api.bompreparo.data.repositories.UserRepository;
import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.models.UserIngredient;
import com.api.bompreparo.domain.services.IngredientService;
import com.api.bompreparo.domain.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredientServiceImpl implements IngredientService {

    @Autowired
    private final IngredientRepository ingredientRepository;

    @Autowired
    private final UserIngredientRepository userIngredientRepository;

    @Autowired
    private final UserService userService;

    @Autowired
    private final UserRepository userRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository, UserIngredientRepository userIngredientRepository, UserService userService, UserRepository userRepository) {
        this.ingredientRepository = ingredientRepository;
        this.userIngredientRepository = userIngredientRepository;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void create(Ingredient obj) {
        ingredientRepository.save(obj);
    }

    @Override
    public Ingredient read(Long id) {
        return ingredientRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("ID não encontrado."));
    }

    @Override
    public void update(Ingredient obj) {
        ingredientRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        ingredientRepository.deleteById(id);
    }

    @Override
    public List<Ingredient> list() {
        return ingredientRepository.findAll();
    }

    @Override
    @Transactional
    public void addIngredientToPantry(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new IllegalArgumentException("O ingrediente não foi encontrado."));

        if (userIngredientRepository.existsByUser_IdAndIngredient_Id(userService.getCurrentUser().getId(), ingredient.getId())) {
            throw new IllegalArgumentException("Você já possui esse ingrediente em sua despensa.");
        }

        UserIngredient userIngredientModel = new UserIngredient();

        userIngredientModel.setIngredient(ingredient);
        userIngredientModel.setUser(userService.getCurrentUser());

        userIngredientRepository.save(userIngredientModel);
    }

    @Override
    @Transactional
    public void createIngredient(Ingredient ingredient) {
        if (ingredient.getName().trim().equals("")) {
            throw new IllegalArgumentException("Por favor, preencha todos os campos.");
        }

        if (ingredientRepository.existsByName(ingredient.getName())) {
            throw new IllegalArgumentException("Já existe um ingrediente com esse nome.");
        }

        Ingredient ingredientModel = new Ingredient();

        ingredientModel.setName(ingredient.getName());

        ingredientModel = ingredientRepository.save(ingredientModel);

        UserIngredient userIngredientModel = new UserIngredient();

        userIngredientModel.setIngredient(ingredientModel);
        userIngredientModel.setUser(userService.getCurrentUser());

        userIngredientRepository.save(userIngredientModel);
    }

    @Override
    public Ingredient getIngredient(Long ingredientId) {
        return ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new IllegalArgumentException("O ingrediente não foi encontrado."));
    }

    @Override
    public List<Ingredient> listIngredients() {
        List<Ingredient> ingredientList = ingredientRepository.findAll();

        if (ingredientList.isEmpty()) {
            throw new IllegalArgumentException("Nenhum ingrediente foi encontrado.");
        }

        return ingredientList;
    }

    @Override
    public List<Ingredient> listIngredientsByCurrentUser() {
        List<UserIngredient> userIngredientList = userIngredientRepository.findByUser_Id(userService.getCurrentUser().getId());

        if (userIngredientList.isEmpty()) {
            throw new IllegalArgumentException("Nenhum ingrediente foi encontrado em sua despensa.");
        }

        return userIngredientList.stream().map(UserIngredient::getIngredient).toList();
    }

    @Override
    @Transactional
    public void removeIngredientFromPantry(Long ingredientId) {
        Ingredient ingredient = ingredientRepository.findById(ingredientId)
                .orElseThrow(() -> new IllegalArgumentException("O ingrediente não foi encontrado."));

        UserIngredient userIngredientModel = userIngredientRepository.findByUser_IdAndIngredient_Id(userService.getCurrentUser().getId(), ingredient.getId())
                .orElseThrow(() -> new IllegalArgumentException("Você não possui esse ingrediente em sua despensa."));

        userIngredientRepository.delete(userIngredientModel);
    }

}
