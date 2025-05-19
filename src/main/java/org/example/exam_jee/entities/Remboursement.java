package org.example.exam_jee.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.exam_jee.enums.TypeRemboursement;

import java.time.LocalDate;

@Entity @Data @AllArgsConstructor @NoArgsConstructor
public class Remboursement {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private double montant;
    @Enumerated(EnumType.STRING)
    private TypeRemboursement type;

    @ManyToOne
    private Credit credit;
}