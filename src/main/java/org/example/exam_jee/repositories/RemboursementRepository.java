package org.example.exam_jee.repositories;

import org.example.exam_jee.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RemboursementRepository extends JpaRepository<Remboursement , Long> {
}
