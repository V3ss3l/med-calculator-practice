package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Schema(description = "Сущность параметров для шкалы HEART")
public class HeartParams {

    @Min(21)
    @Max(120)
    @Schema(description = "Возраст")
    private int age;

    @Min(0)
    @Max(2)
    @Schema(description = "Анамнез")
    private int anamnez;

    @Min(0)
    @Max(2)
    @Schema(description = "ЭКГ")
    private int ecg;

    @Min(0)
    @Max(2)
    @Schema(description = "Факторы риска")
    private int riskFactor;

    @Min(0)
    @Max(2)
    @Schema(description = "Исходный тропонин")
    private int troponin;
}
