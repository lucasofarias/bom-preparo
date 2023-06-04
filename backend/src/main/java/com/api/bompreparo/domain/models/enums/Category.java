package com.api.bompreparo.domain.models.enums;

public enum Category {

    DOCES("Doces"),
    SALGADOS("Salgados"),
    BEBIDAS("Bebidas");

    public final String value;

    Category(String value) {
        this.value = value;
    }

}
