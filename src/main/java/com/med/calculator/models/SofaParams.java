package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сущность параметров для шкалы SOFA")
public class SofaParams {

    @Schema(description = "Парциальное напряжение кислорода")
    private int paO2;

    @Schema(description = "Концентрация кислорода на вдохе")
    private int fio2;

    @Schema(description = "Тромбоциты")
    private int platelets;

    @Schema(description = "Билирубин")
    private int bilirubin;

    @Schema(description = "Тип оценки почечной функции")
    private boolean liverCheck;

    @Schema(description = "Параметр содержащий в себе значение креатинин/суточный диурез")
    private int liverParam;

    @Schema(description = "Среднее артериальное давление")
    private int hypotensia;

    @Schema(description = "Результат вычисления шкалы комы Глазго")
    private int gcs;
}
