package org.example.exam_jee.mappers;


import org.example.exam_jee.dtos.CreditProfessionnelDTO;
import org.example.exam_jee.entities.CreditProfessionnel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditProfessionnelMapper {
    CreditProfessionnelDTO toDTO(CreditProfessionnel credit);
    CreditProfessionnel toEntity(CreditProfessionnelDTO dto);
}