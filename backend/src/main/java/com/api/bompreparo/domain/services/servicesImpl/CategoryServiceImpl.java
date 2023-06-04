package com.api.bompreparo.domain.services.servicesImpl;

import com.api.bompreparo.data.repositories.CategoryRepository;
import com.api.bompreparo.domain.models.enums.Category;
import com.api.bompreparo.domain.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> listCategories() {
        List<Category> categoryList = categoryRepository.findAll();

        if (categoryList.isEmpty()) {
            throw new IllegalArgumentException("Nenhuma categoria foi encontrada.");
        }

        return categoryList;
    }

}
