package org.example.exam_jee.dtos;


import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String nom;
    private String email;
}