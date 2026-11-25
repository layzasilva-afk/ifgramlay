package br.edu.ifpb.ifgram.dto;

import java.time.LocalDateTime;
import br.edu.ifpb.ifgram.Model.Comment;

public record CommentResponse(
        Long id,
        String texto,
        LocalDateTime criadoEm,
        String autorNome,
        Long postId
) {

    public static CommentResponse from(Comment comment) {
        return new CommentResponse(
                comment.getId(),
                comment.getTexto(),
                comment.getCriadoEm(),
                comment.getAutor().getNome(),
                comment.getPost().getId()
        );
    }
}