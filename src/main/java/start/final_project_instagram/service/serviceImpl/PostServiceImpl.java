package start.final_project_instagram.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.PostRequest;
import start.final_project_instagram.dto.response.PostResponse;
import start.final_project_instagram.entities.Image;
import start.final_project_instagram.entities.Like;
import start.final_project_instagram.entities.Post;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.repositories.PostRepository;
import start.final_project_instagram.repositories.UserRepository;
import start.final_project_instagram.service.PostService;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    @Override
    public PostResponse createPost(PostRequest postRequest) {
        User user = userRepository.findById(1L).orElseThrow(() -> new RuntimeException("User not found"));
        Post post = new Post();
        post.setTitle(postRequest.title());
        post.setDescription(postRequest.description());
        post.setCreatedAt(LocalDateTime.now());
        post.setUser(user);
        post.setImages(List.of(new Image(null, "default_image_url", post)));
        post.setLikes(List.of(new Like(null, post, user)));
        Post savedPost = postRepository.save(post);
        return new PostResponse(savedPost.getId(), savedPost.getTitle(), savedPost.getDescription(), savedPost.getCreatedAt().toString());
    }
    @Override
    public PostResponse getPostById(Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        return new PostResponse(post.getId(), post.getTitle(), post.getDescription(), post.getCreatedAt().toString());
    }
    @Override
    public PostResponse updatePost(Long postId, PostRequest postRequest) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new RuntimeException("Post not found"));
        post.setTitle(postRequest.title());
        post.setDescription(postRequest.description());
        return new PostResponse(post.getId(), post.getTitle(), post.getDescription(), post.getCreatedAt().toString());
    }
    @Override
    public void deletePost(Long postId) {
        postRepository.deleteById(postId);
    }
    @Override
    public List<PostResponse> getAllPosts() {
        return postRepository.findAll().stream()
                .map(post -> new PostResponse(post.getId(), post.getTitle(), post.getDescription(), post.getCreatedAt().toString()))
                .collect(Collectors.toList());
    }
    @Override
    public List<PostResponse> getUserFeed(Long userId) {
        return postRepository.findAll().stream()
                .filter(post -> post.getUser().getId().equals(userId))
                .sorted((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt()))
                .map(post -> new PostResponse(post.getId(), post.getTitle(), post.getDescription(), post.getCreatedAt().toString()))
                .collect(Collectors.toList());
    }
}