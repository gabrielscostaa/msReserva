package com.reserva.reserva.aplication.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reserva.reserva.aplication.dto.Reserva;
import com.reserva.reserva.infrastruture.repository.ReservaRepository;

@Service
public class ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    public Reserva getReservaById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }

    public Reserva createReserva(Reserva reserva) {
        // Nenhuma verificação, apenas salva
        return reservaRepository.save(reserva);
    }
}
