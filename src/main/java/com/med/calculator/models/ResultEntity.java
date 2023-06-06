package com.med.calculator.models;

import lombok.Data;

@Data
public class ResultEntity {
    // результат вычисления в виде баллов
    private int result;
    // результат трансляции баллов в информацию для пациентов
    private String info;
}
