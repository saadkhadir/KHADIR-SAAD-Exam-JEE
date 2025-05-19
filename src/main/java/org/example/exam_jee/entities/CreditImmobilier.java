package org.example.exam_jee.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
@DiscriminatorValue("IMMOBILIER")
public class CreditImmobilier extends Credit {
    @Enumerated(EnumType.STRING)
    private TypeBien typeBien;
}