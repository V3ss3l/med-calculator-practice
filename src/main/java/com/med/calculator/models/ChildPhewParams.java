package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;

@Data
@Schema(description = "Сущность параметров для шкалы Чайлд Пью")
public class ChildPhewParams {

    @Min(1)
    @Max(3)
    @Schema(description = "Билирубин")
    private int bilirubin;

    @Min(1)
    @Max(3)
    @Schema(description = "Альбумин")
    private int albumin;

    @Min(1)
    @Max(3)
    @Schema(description = "МНО")
    private int mho;

    @Min(1)
    @Max(3)
    @Schema(description = "Асцит")
    private int ascit;

    @Min(1)
    @Max(3)
    @Schema(description = "Энцефалопатия")
    private int enceph;

}
