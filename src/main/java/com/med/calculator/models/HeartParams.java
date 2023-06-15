package com.med.calculator.models;

import lombok.Data;

@Data
public class HeartParams {

    private int age; // Возраст

    private int anamnez; // Анамнез

    private int ecg; //  ЭКГ

    private int riskFactor; // Факторы риска

    private int troponin; // Исходный тропонин
}
