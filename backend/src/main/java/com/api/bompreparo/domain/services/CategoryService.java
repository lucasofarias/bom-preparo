package com.api.bompreparo.domain.services;

import com.api.bompreparo.domain.models.dtos.category.CategoryDTO;

import java.util.List;

public interface CategoryService {

    List<CategoryDTO> listCategories();

}
