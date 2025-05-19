package org.example.exam_jee.dtos;


import lombok.Data;


@Data

public class CreditPersonnelDTO extends CreditDTO {
    private String motif; // ex : achat voiture, études...
}