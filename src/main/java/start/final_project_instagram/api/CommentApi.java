package start.final_project_instagram.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.final_project_instagram.dto.request.CommentRequest;
import start.final_project_instagram.dto.response.CommentResponse;
import start.final_project_instagram.service.CommentService;

import java.util.List;
@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentApi {
    private final CommentService commentService;

    @PostMapping("/{userId}/{postId}")
    public ResponseEntity<CommentResponse> saveComment(@RequestBody CommentRequest request,
                                                       @PathVariable Long userId,
                                                       @PathVariable Long postId) {
        return ResponseEntity.ok(commentService.saveComment(request, userId, postId));
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<List<CommentResponse>> getAllCommentsByPost(@PathVariable Long postId) {
        return ResponseEntity.ok(commentService.findAllByPostId(postId));
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deleteComment(@PathVariable Long commentId) {
        commentService.deleteCommentById(commentId);
        return ResponseEntity.noContent().build();
    }
}