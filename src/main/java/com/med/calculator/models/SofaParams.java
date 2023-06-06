package com.med.calculator.models;

import lombok.Data;

@Data
public class SofaParams {

    // респираторный индекс Каррико
    private int paO2;
    private int fio2;
    // респираторный индекс Каррико


    private int platelets; // Тромбоциты


    private int bilirubin; //Билирубин


    private boolean liverCheck; // Вид оценки почечной функции


    private int liverParam; // Креатинин или суточный диурез


    private int hypotensia; // Среднее артериальное давление или нуждаеомсть в вазопроцессорах


    private int gcs; // Шкала комы Глазго
}
