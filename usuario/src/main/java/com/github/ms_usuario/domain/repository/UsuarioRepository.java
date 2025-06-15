package com.github.ms_usuario.domain.repository;

import com.github.ms_usuario.domain.model.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    List<Usuario> buscarTodos();
    Optional<Usuario> buscarPorId(Long id);
} 