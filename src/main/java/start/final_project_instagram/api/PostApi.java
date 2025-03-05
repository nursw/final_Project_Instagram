package start.final_project_instagram.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.final_project_instagram.dto.request.PostRequest;
import start.final_project_instagram.dto.response.PostResponse;
import start.final_project_instagram.service.PostService;

import java.util.List;
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostApi {
    private final PostService postService;

    // Create a new post
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest postRequest) {
        PostResponse postResponse = postService.createPost(postRequest);
        return new ResponseEntity<>(postResponse, HttpStatus.CREATED);
    }

    // Get a post by its ID
    @GetMapping("/{postId}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable Long postId) {
        PostResponse postResponse = postService.getPostById(postId);
        return ResponseEntity.ok(postResponse);
    }

    // Update an existing post
    @PutMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long postId, @RequestBody PostRequest postRequest) {
        PostResponse postResponse = postService.updatePost(postId, postRequest);
        return ResponseEntity.ok(postResponse);
    }

    // Delete a post
    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable Long postId) {
        postService.deletePost(postId);
        return ResponseEntity.noContent().build();
    }

    // Get all posts
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        List<PostResponse> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get user's feed (posts made by a specific user)
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostResponse>> getUserFeed(@PathVariable Long userId) {
        List<PostResponse> userFeed = postService.getUserFeed(userId);
        return ResponseEntity.ok(userFeed);
    }
}