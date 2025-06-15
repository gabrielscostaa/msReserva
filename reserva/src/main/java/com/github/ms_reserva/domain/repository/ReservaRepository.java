package com.reserva.reserva.domain.repository;

import com.reserva.reserva.domain.model.Reserva;

import java.util.List;
import java.util.Optional;

public interface ReservaRepository {
    Optional<Reserva> findById(Long id);
    List<Reserva> findAll();
    Reserva save(Reserva reserva);
}