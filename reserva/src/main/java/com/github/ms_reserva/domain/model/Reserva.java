package com.reserva.reserva.domain.model;

import com.reserva.reserva.domain.model.value.DataHora;
import com.reserva.reserva.domain.model.value.SalaId;
import com.reserva.reserva.domain.model.value.UsuarioId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverride(name = "dataHora", column = @Column(name = "data_hora"))
    private DataHora dataHora;

    @Embedded
    @AttributeOverride(name = "salaId", column = @Column(name = "sala_id"))
    private SalaId salaId;

    @Embedded
    @AttributeOverride(name = "usuarioId", column = @Column(name = "usuario_id"))
    private UsuarioId usuarioId;

    public Reserva(DataHora dataHora, SalaId salaId, UsuarioId usuarioId) {
        this.dataHora = dataHora;
        this.salaId = salaId;
        this.usuarioId = usuarioId;
    }
}
