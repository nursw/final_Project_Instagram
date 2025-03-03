package start.final_project_instagram.service;

import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.CommentRequest;
import start.final_project_instagram.dto.response.CommentResponse;

import java.util.List;

@Service
public interface CommentService {
    CommentResponse saveComment(CommentRequest commentRequest, Long userId, Long postId);
    List<CommentResponse> findAllByPostId(Long postId);
    void deleteCommentById(Long commentId);
}
