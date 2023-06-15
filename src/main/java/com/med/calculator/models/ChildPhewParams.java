package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "Сущность параметров для шкалы Чайлд Пью")
public class ChildPhewParams {

    @Schema(description = "Билирубин")
    private int bilirubin;

    @Schema(description = "Альбумин")
    private int albumin;

    @Schema(description = "МНО")
    private int mho;

    @Schema(description = "Асцит")
    private int ascit;

    @Schema(description = "Энцефалопатия")
    private int enceph;

}
