package org.example.exam_jee.mappers;


import org.example.exam_jee.dtos.RemboursementDTO;
import org.example.exam_jee.entities.Remboursement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RemboursementMapper {
    RemboursementDTO toDTO(Remboursement remboursement);
    Remboursement toEntity(RemboursementDTO dto);
}