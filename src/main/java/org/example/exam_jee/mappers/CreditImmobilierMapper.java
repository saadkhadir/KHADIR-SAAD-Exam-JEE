package org.example.exam_jee.mappers;


import org.example.exam_jee.dtos.CreditImmobilierDTO;
import org.example.exam_jee.entities.CreditImmobilier;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditImmobilierMapper {
    CreditImmobilierDTO toDTO(CreditImmobilier credit);
    CreditImmobilier toEntity(CreditImmobilierDTO dto);
}