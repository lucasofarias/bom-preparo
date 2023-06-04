package com.api.bompreparo.domain.models.dtos.ingredient;

import com.api.bompreparo.domain.models.Ingredient;
import com.api.bompreparo.domain.models.enums.MeasurementUnit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data @NoArgsConstructor @AllArgsConstructor
public class IngredientDTO {

    private String name;
    private String quantity;
    private MeasurementUnit measurementUnit;
    private Boolean isOptional;

    public static IngredientDTO toDTO(Ingredient ingredient) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper.map(ingredient, IngredientDTO.class);
    }

}
