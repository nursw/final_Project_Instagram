package start.final_project_instagram.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.CommentRequest;
import start.final_project_instagram.dto.response.CommentResponse;
import start.final_project_instagram.entities.Comment;
import start.final_project_instagram.entities.Post;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.repositories.CommentRepository;
import start.final_project_instagram.repositories.PostRepository;
import start.final_project_instagram.repositories.UserRepository;
import start.final_project_instagram.service.CommentService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public CommentResponse saveComment(CommentRequest commentRequest, Long userId, Long postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException("Post not found"));
        Comment comment = new Comment();
        comment.setComment(commentRequest.comment());
        comment.setCreatedAt(LocalDateTime.now().toString());
        comment.setUser(user);
        comment.setPost(post);
        comment.setLikes(List.of());
        Comment savedComment = commentRepository.save(comment);
        return new CommentResponse(savedComment.getId(), savedComment.getComment(), savedComment.getCreatedAt());
    }
    @Override
    public List<CommentResponse> findAllByPostId(Long postId) {
        return commentRepository.findByPostId(postId).stream()
                .map(comment -> new CommentResponse(comment.getId(), comment.getComment(), comment.getCreatedAt()))
                .collect(Collectors.toList());
    }
    @Override
    public void deleteCommentById(Long commentId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("Comment not found"));
        comment.getLikes().clear();
        commentRepository.delete(comment);
    }
}