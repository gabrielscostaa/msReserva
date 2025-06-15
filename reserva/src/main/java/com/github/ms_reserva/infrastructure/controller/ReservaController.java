package com.reserva.reserva.infrastructure.controller;

import com.reserva.reserva.application.ReservaService;
import com.reserva.reserva.domain.model.Reserva;
import com.reserva.reserva.infrastructure.controller.dto.ReservaRequestDTO;
import com.reserva.reserva.infrastructure.controller.dto.ReservaResponseDTO;
import com.reserva.reserva.infrastructure.controller.mapper.ReservaMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @GetMapping
    public ResponseEntity<List<ReservaResponseDTO>> listar() {
        List<ReservaResponseDTO> reservas = reservaService.listar()
                .stream()
                .map(ReservaMapper::toDTO)
                .toList();

        return ResponseEntity.ok(reservas);
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> salvar(@RequestBody ReservaRequestDTO reservaRequestDTO) {
        Reserva reserva = ReservaMapper.toEntity(reservaRequestDTO);
        Reserva saved = reservaService.salvar(reserva);
        return ResponseEntity.ok(ReservaMapper.toDTO(saved));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaResponseDTO> buscarPorId(@PathVariable Long id) {
        return reservaService.buscarPorId(id)
                .map(ReservaMapper::toDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}