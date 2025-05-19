package org.example.exam_jee.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Credit> credits;
}