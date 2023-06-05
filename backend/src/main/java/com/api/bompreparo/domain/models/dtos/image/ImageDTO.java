package com.api.bompreparo.domain.models.dtos.image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;

@Data @NoArgsConstructor @AllArgsConstructor
public class ImageDTO {

    private Long imageId;
    private Blob data;

}
