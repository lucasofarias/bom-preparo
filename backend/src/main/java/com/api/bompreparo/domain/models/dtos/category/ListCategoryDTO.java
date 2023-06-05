package com.api.bompreparo.domain.models.dtos.category;

import com.api.bompreparo.domain.models.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

@Data @NoArgsConstructor @AllArgsConstructor
public class ListCategoryDTO {

    private Long categoryId;
    private String name;

    public static List<ListCategoryDTO> toListDTO(List<Category> categories) {
        ModelMapper modelMapper = new ModelMapper();

        List<ListCategoryDTO> dtos = categories
                .stream()
                .map(x -> modelMapper.map(x, ListCategoryDTO.class))
                .collect(Collectors.toList());

        return dtos;
    }

}
