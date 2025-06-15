package com.sala.sala.domain.model;

import com.sala.sala.domain.model.value.Capacidade;
import com.sala.sala.domain.model.value.Nome;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Embedded
    private Nome nome;
    @Embedded
    private Capacidade capacidade;

    public Sala(Nome nome, Capacidade capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }
}