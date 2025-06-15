package com.reserva.reserva.infrastructure.repository;

import com.reserva.reserva.domain.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataReservaRepository extends JpaRepository<Reserva, Long> {
}