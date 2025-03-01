package start.final_project_instagram.dto.response;

import lombok.Builder;
import lombok.Data;
import start.final_project_instagram.entities.User;

import java.util.List;
@Data
@Builder
public class UserResponseDto {
    private Long id;
    private String email;
    private String phoneNumber;
    private String username;
    private String image;
    private String fullName;
    private int subscribersCount;
    private int subscriptionsCount;
    private List<String> posts;
}
