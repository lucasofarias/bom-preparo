package com.api.bompreparo.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Image {

    @Id @GeneratedValue
    private UUID id;
    private String type;

    @Lob
    private byte[] data;

    @ManyToOne
    private Recipe recipe;

}
