package org.example.exam_jee.mappers;

import org.example.exam_jee.dtos.ClientDTO;
import org.example.exam_jee.entities.Client;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClientMapper {
    ClientDTO toDTO(Client client);
    Client toEntity(ClientDTO dto);
}