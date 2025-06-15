package com.github.ms_usuario.infrastructure.controller;

import com.github.ms_usuario.application.UsuarioService;
import com.github.ms_usuario.domain.model.Usuario;
import com.github.ms_usuario.domain.model.value.Cpf;
import com.github.ms_usuario.domain.model.value.DataNascimento;
import com.github.ms_usuario.domain.model.value.Email;
import com.github.ms_usuario.domain.model.value.Nome;
import com.github.ms_usuario.infrastructure.controller.dto.UsuarioRequestDTO;
import com.github.ms_usuario.infrastructure.controller.dto.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<Usuario> criarUsuario(@RequestBody UsuarioRequestDTO userDTO) {
        Usuario usuario = new Usuario(
                new Nome(userDTO.nome()),
                new Email(userDTO.email()),
                new Cpf(userDTO.cpf()),
                new DataNascimento(userDTO.dataNascimento())
        );
        return ResponseEntity.ok(usuarioService.criarUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponseDTO>> listarUsuarios() {
        List<Usuario> usuarios = usuarioService.buscarTodos();

        List<UsuarioResponseDTO> responseDTOs = usuarios.stream()
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome().getNome(),
                        usuario.getEmail().getEmail(),
                        usuario.getCpf().getCpf(),
                        usuario.getDataNascimento().getDataNascimento()
                ))
                .toList();

        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@PathVariable Long id) {
        return usuarioService.buscarPorId(id)
                .map(usuario -> new UsuarioResponseDTO(
                        usuario.getId(),
                        usuario.getNome().getNome(),
                        usuario.getEmail().getEmail(),
                        usuario.getCpf().getCpf(),
                        usuario.getDataNascimento().getDataNascimento()
                ))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
} 