package com.reserva.reserva.infrastructure.messaging;

import com.reserva.reserva.application.UsuarioService;
import com.reserva.reserva.infrastructure.messaging.dto.UsuarioMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConsumer {
    private final UsuarioService usuarioService;

    public UsuarioConsumer(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RabbitListener(queues = "${rabbitmq.queue.usuario.response}")
    public void consumirReposta(UsuarioMessage message) {
        usuarioService.receberResultadoValidacao(message);
    }
}
