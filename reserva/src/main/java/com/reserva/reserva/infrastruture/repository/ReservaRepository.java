package com.reserva.reserva.infrastruture.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reserva.reserva.aplication.dto.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{
    
}
