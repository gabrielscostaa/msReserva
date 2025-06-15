package com.reserva.reserva.infrastructure.controller.dto;

public record ReservaRequestDTO(String dataHora,
                                Long salaId,
                                Long usuarioId) {
}
