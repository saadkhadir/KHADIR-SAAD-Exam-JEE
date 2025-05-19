package org.example.exam_jee.repositories;

import org.example.exam_jee.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
