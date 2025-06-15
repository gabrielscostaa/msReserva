package com.sala.sala.infrastructure.repository;

import com.sala.sala.domain.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSalaRepository extends JpaRepository<Sala, Long> {
}