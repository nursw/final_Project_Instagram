package start.final_project_instagram.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.response.ImageResponse;
import start.final_project_instagram.entities.Image;
import start.final_project_instagram.repositories.ImageRepository;
import start.final_project_instagram.service.ImageService;
@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;
    @Override
    public ImageResponse addImage(Long postId, String imageUrl) {
        Image image = new Image(null, imageUrl, null);
        imageRepository.save(image);
        return new ImageResponse(image.getId(), image.getImageUrl());
    }
    @Override
    public ImageResponse getImageByPostId(Long postId) {
        Image image = imageRepository.findById(postId).orElseThrow(() -> new RuntimeException("Image not found"));
        return new ImageResponse(image.getId(), image.getImageUrl());
    }
    @Override
    public void deleteImage(Long postId) {
        imageRepository.deleteById(postId);
    }
}