package com.api.bompreparo.domain.models.dtos.user;

import com.api.bompreparo.domain.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

@Data @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private Long userId;
    private String username;
    private String fullName;
    private String email;

    public static UserDTO toDTO(User user) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);

        return modelMapper.map(user, UserDTO.class);
    }

}
