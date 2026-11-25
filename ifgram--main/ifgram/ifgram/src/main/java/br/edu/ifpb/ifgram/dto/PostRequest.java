package br.edu.ifpb.ifgram.dto;

import java.time.LocalDateTime;

public record PostRequest(
        String imagemUrl,
        String legenda,
        LocalDateTime criadoEm,
        Long autorId,
        String autorNome
) {
}