package org.example.exam_jee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PERSONNEL")
public class CreditPersonnel extends Credit {
    private String motif;
}