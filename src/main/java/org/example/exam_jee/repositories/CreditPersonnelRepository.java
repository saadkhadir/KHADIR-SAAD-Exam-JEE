package org.example.exam_jee.repositories;

import org.example.exam_jee.entities.CreditPersonnel;
import org.hibernate.annotations.LazyToOne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditPersonnelRepository extends JpaRepository<CreditPersonnel , Long> {
}
