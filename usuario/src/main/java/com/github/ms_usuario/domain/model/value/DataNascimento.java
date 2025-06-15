package com.github.ms_usuario.domain.model.value;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import java.time.LocalDate;

@Embeddable
@Getter
public class DataNascimento {
    private LocalDate dataNascimento;

    public DataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento não pode ser futura");
        }
        this.dataNascimento = dataNascimento;
    }

    protected DataNascimento() {
        // Construtor protegido para JPA
    }
} 