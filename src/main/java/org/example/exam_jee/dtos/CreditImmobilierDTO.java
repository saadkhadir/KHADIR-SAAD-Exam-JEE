package org.example.exam_jee.dtos;

import lombok.Data;

import org.example.exam_jee.enums.TypeBien;

@Data

public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}