package org.example.exam_jee.dtos;

import lombok.Data;
import org.example.exam_jee.enums.StatutCredit;

import java.time.LocalDate;

@Data
public class CreditDTO {
    private Long id;
    private LocalDate dateDemande;
    private StatutCredit statut;
    private LocalDate dateAcception;
    private double montant;
    private int duree;
    private double tauxInteret;
    private Long clientId;
}