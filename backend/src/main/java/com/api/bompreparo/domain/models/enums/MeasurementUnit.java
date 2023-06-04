package com.api.bompreparo.domain.models.enums;

public enum MeasurementUnit {

    COLHER_CHA("Colher(es) de chá"),
    COLHER_SOPA("Colher(es) de sopa"),
    COPO("Copo(s)"),
    FATIA("Fatia(s)"),
    GRAMA("g"),
    LITRO("L"),
    MILILITRO("ml"),
    PACOTE("Pacote(s)"),
    PEDACO("Pedaço(s)"),
    QUANTIDADE("Quantidade(s)"),
    QUILOGRAMA("kg"),
    XICARA_CHA("Xícara(s) de chá"),
    XICARA_CAFE("Xícara(s) de café");

    public final String value;

    MeasurementUnit(String value) {
        this.value = value;
    }

}
