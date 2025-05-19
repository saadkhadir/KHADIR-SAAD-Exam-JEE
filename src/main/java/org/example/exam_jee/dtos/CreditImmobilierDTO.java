package org.example.exam_jee.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.exam_jee.enums.TypeBien;

@Data
@EqualsAndHashCode(callSuper = true)
public class CreditImmobilierDTO extends CreditDTO {
    private TypeBien typeBien;
}