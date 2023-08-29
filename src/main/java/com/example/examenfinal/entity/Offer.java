package com.example.examenfinal.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Offer {
    private int id;
    private String titre;
    private String description;
    private String entreprise;
    private BigDecimal salary;
    private String city;
    private boolean remote;
    private int domainId;
}
