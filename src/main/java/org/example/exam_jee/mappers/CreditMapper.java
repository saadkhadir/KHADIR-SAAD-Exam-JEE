package org.example.exam_jee.mappers;


import org.example.exam_jee.dtos.CreditDTO;
import org.example.exam_jee.entities.Credit;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreditMapper {
    CreditDTO toDTO(Credit credit);
    Credit toEntity(CreditDTO dto);
}