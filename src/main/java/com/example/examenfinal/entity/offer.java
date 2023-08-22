package com.example.examenfinal.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
    private double salary;
    private String city;
    private boolean remote;
    private int domainId; // Ajout de la référence au domaine
}
