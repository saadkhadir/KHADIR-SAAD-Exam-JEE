package org.example.exam_jee.mappers;


import org.example.exam_jee.dtos.CreditPersonnelDTO;
import org.example.exam_jee.entities.CreditPersonnel;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = { ClientMapper.class })
public interface CreditPersonnelMapper {
    CreditPersonnelDTO toDTO(CreditPersonnel credit);
    CreditPersonnel toEntity(CreditPersonnelDTO dto);
}