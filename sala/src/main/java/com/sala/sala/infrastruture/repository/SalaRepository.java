package com.sala.sala.infrastruture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sala.sala.application.dto.Sala;

public interface SalaRepository extends JpaRepository<Sala, Long> {
    
}
