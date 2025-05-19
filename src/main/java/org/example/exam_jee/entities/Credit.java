package org.example.exam_jee.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity @Data
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_CREDIT")
public abstract class Credit {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate dateDemande;
    @Enumerated(EnumType.STRING)
    private StatutCredit statut;
    private LocalDate dateAcceptation;
    private double montant;
    private int dureeRemboursement;
    private float tauxInteret;
    @ManyToOne
    private Client client;
    @OneToMany(mappedBy = "credit")
    private List<Remboursement> remboursements;
}
