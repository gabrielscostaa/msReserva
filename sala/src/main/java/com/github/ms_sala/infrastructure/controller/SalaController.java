package com.sala.sala.infrastructure.controller;

import com.sala.sala.application.SalaService;
import com.sala.sala.domain.model.Sala;
import com.sala.sala.domain.model.value.Nome;
import com.sala.sala.domain.model.value.Capacidade;
import com.sala.sala.infrastructure.controller.dto.SalaRequestDTO;
import com.sala.sala.infrastructure.controller.dto.SalaResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/salas")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @PostMapping
    public ResponseEntity<SalaResponseDTO> criarSala(@RequestBody SalaRequestDTO request) {
        Sala sala = new Sala(new Nome(request.nome()), new Capacidade(request.capacidade()));
        Sala novaSala = salaService.criarSala(sala);
        return ResponseEntity.ok(toDTO(novaSala));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalaResponseDTO> buscarPorId(@PathVariable Long id) {
        Optional<Sala> sala = salaService.buscarPorId(id);
        return sala.map(s -> ResponseEntity.ok(toDTO(s)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<SalaResponseDTO>> listarTodas() {
        List<SalaResponseDTO> salasDTO = salaService.listarTodas()
                .stream()
                .map(this::toDTO)
                .toList();
        return ResponseEntity.ok(salasDTO);
    }

    private SalaResponseDTO toDTO(Sala sala) {
        return new SalaResponseDTO(
                sala.getId(),
                sala.getNome().getNome(),
                sala.getCapacidade().getCapacidade()
        );
    }
}
