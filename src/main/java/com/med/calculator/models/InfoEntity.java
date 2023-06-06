package com.med.calculator.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CALC_INFO")
public class InfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String info;

    private int owner;
}
