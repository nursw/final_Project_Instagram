package start.final_project_instagram.service;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.response.ImageResponse;
@Service
public interface ImageService {
    ImageResponse addImage(Long postId, String imageUrl);
    ImageResponse getImageByPostId(Long postId);
    void deleteImage(Long postId);
}