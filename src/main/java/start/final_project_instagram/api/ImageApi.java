package start.final_project_instagram.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.final_project_instagram.dto.response.ImageResponse;
import start.final_project_instagram.service.ImageService;

@RestController
@RequestMapping("/api/images")
@RequiredArgsConstructor
public class ImageApi {
    private final ImageService imageService;

    @PostMapping("/add/{postId}")
    public ResponseEntity<ImageResponse> addImage(@PathVariable Long postId, @RequestParam String imageUrl) {
        return ResponseEntity.ok(imageService.addImage(postId, imageUrl));
    }

    @GetMapping("/{postId}")
    public ResponseEntity<ImageResponse> getImageByPostId(@PathVariable Long postId) {
        return ResponseEntity.ok(imageService.getImageByPostId(postId));
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long postId) {
        imageService.deleteImage(postId);
        return ResponseEntity.noContent().build();
    }
}