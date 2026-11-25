package br.edu.ifpb.ifgram.controller;

import br.edu.ifpb.ifgram.dto.CommentRequest;
import br.edu.ifpb.ifgram.dto.CommentResponse;
import br.edu.ifpb.ifgram.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public CommentResponse criar(
            @Valid @RequestBody CommentRequest request) {
        return commentService.criar(request);
    }

    @GetMapping("/post/{postId}")
    public List<CommentResponse> listarPorPost(
            @PathVariable Long postId) {
        return commentService.listarPorPost(postId);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        commentService.deletar(id);
    }
}
