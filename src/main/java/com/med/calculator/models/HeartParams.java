package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сущность параметров для шкалы HEART")
public class HeartParams {

    @Schema(description = "Возраст")
    private int age;

    @Schema(description = "Анамнез")
    private int anamnez;

    @Schema(description = "ЭКГ")
    private int ecg;

    @Schema(description = "Факторы риска")
    private int riskFactor;

    @Schema(description = "Исходный тропонин")
    private int troponin;
}
