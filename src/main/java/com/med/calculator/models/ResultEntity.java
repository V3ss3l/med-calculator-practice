package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Резултирующая сущность")
public class ResultEntity {
    @Schema(description = "Результат вычисления в виде баллов")
    private int result;
    @Schema(description = "Результат трансляции баллов в информацию для пациентов")
    private String info;
    @Schema(description = "Дополнительная информация для трансляции результатов")
    private String addInfo;
}
