package com.github.ms_usuario.infrastructure.config;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Value("${rabbitmq.queue.usuario.request}")
    private String usuarioRequestQueue;

    @Value("${rabbitmq.queue.usuario.response}")
    private String usuarioResponseQueue;

    @Bean
    public Queue usuarioRequestQueue() {
        return new Queue(usuarioRequestQueue, true);
    }

    @Bean
    public Queue usuarioResponseQueue() {
        return new Queue(usuarioResponseQueue, true);
    }
} 