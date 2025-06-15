package com.github.ms_usuario.application;

import com.github.ms_usuario.domain.model.Usuario;
import com.github.ms_usuario.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    public List<Usuario> buscarTodos() {
        return usuarioRepository.buscarTodos();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.buscarPorId(id);
    }
} 