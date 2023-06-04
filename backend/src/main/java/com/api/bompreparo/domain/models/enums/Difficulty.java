package com.api.bompreparo.domain.models.enums;

public enum Difficulty {

    FACIL("Fácil"),
    MEDIO("Médio"),
    DIFICIL("Difícil");

    public final String value;

    Difficulty(String value) {
        this.value = value;
    }

}
