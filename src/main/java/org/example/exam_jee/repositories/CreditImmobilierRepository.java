package org.example.exam_jee.repositories;

import org.example.exam_jee.entities.CreditImmobilier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditImmobilierRepository extends JpaRepository<CreditImmobilier, Long> {
}
