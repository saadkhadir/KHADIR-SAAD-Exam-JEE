package org.example.exam_jee.repositories;

import org.example.exam_jee.entities.Remboursement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RemboursementRepository extends JpaRepository<Remboursement , Long> {
    List<Remboursement> findByCreditId(Long creditId);
}
