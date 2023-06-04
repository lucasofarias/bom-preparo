package com.api.bompreparo.domain.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Builder
@Data @NoArgsConstructor @AllArgsConstructor
public class Image {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;

    @Lob
    @Column(length = 1000)
    private byte[] data;

    @ManyToOne
    private Recipe recipe;

}
