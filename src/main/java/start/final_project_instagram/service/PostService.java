package start.final_project_instagram.service;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.PostRequest;
import start.final_project_instagram.dto.response.PostResponse;
import java.util.List;
@Service
public interface PostService {
    PostResponse createPost(PostRequest postRequest);
    PostResponse getPostById(Long postId);
    PostResponse updatePost(Long postId, PostRequest postRequest);
    void deletePost(Long postId);
    List<PostResponse> getAllPosts();
    List<PostResponse> getUserFeed(Long userId);
}