package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
@Schema(description = "Сущность параметров для шкалы SOFA")
public class SofaParams {
    @Min(0)
    @Max(1000)
    @Schema(description = "Парциальное напряжение кислорода")
    private int paO2;

    @Min(0)
    @Max(1000)
    @NotNull(message = "Parameter - fio2 is required")
    @Schema(description = "Концентрация кислорода на вдохе")
    private int fio2;

    @Min(0)
    @Max(1000)
    @Schema(description = "Тромбоциты")
    private int platelets;

    @Min(0)
    @Max(1000)
    @Schema(description = "Билирубин")
    private int bilirubin;

    @NotNull(message = "Parameter - type of liver function is required")
    @Schema(description = "Тип оценки почечной функции")
    private boolean liverCheck;

    @Min(0)
    @Max(1000)
    @Schema(description = "Параметр содержащий в себе значение креатинин/суточный диурез")
    private int liverParam;

    @Min(0)
    @Max(1000)
    @Schema(description = "Среднее артериальное давление")
    private int hypotensia;

    @Schema(description = "Результат вычисления шкалы комы Глазго")
    private int gcs;
}
