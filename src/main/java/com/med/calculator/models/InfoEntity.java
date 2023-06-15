package com.med.calculator.models;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Schema(description = "Сущность с информации о калькуляторе")
public class InfoEntity {
    @Schema(description = "Краткая информация о калькуляторе")
    private String info;
}
