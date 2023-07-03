package com.med.calculator.services;

import com.med.calculator.models.ResultEntity;

public interface CalculatorService<T> {
    ResultEntity CalculateScore(T params);

    ResultEntity ResultCalculation(int score);
}
