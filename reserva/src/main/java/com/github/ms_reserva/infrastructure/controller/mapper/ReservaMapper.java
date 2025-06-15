package com.reserva.reserva.infrastructure.controller.mapper;

import com.reserva.reserva.domain.model.Reserva;
import com.reserva.reserva.domain.model.value.*;
import com.reserva.reserva.infrastructure.controller.dto.ReservaRequestDTO;
import com.reserva.reserva.infrastructure.controller.dto.ReservaResponseDTO;

import java.time.LocalDateTime;

public class ReservaMapper {

    public static Reserva toEntity(ReservaRequestDTO dto) {
        return new Reserva(
                new DataHora(LocalDateTime.parse(dto.dataHora())),
                new SalaId(dto.salaId()),
                new UsuarioId(dto.usuarioId())
        );
    }

    public static ReservaResponseDTO toDTO(Reserva reserva) {
        return new ReservaResponseDTO(
                reserva.getId(),
                reserva.getDataHora().getDataHora().toString(),
                reserva.getSalaId().getSalaId(),
                reserva.getUsuarioId().getUsuarioId()
        );
    }
}
