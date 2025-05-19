package org.example.exam_jee.repositories;

import org.example.exam_jee.entities.Credit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditRepository extends JpaRepository<Credit, Long> {
}
