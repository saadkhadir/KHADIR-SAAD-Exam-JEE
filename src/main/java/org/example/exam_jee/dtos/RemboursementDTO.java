package org.example.exam_jee.dtos;

import lombok.Data;
import org.example.exam_jee.enums.TypeRemboursement;

import java.time.LocalDate;

@Data
public class RemboursementDTO {
    private Long id;
    private LocalDate date;
    private double montant;
    private TypeRemboursement type;
    private Long creditId;
}