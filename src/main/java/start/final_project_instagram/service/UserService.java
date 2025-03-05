package start.final_project_instagram.service;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.UserRequest;
import start.final_project_instagram.dto.response.UserResponse;
import java.util.List;
@Service
public interface UserService {
    UserResponse signUp(UserRequest userRequest);
    UserResponse signIn(UserRequest userRequest);
    UserResponse getUserProfile(Long userId);
    UserResponse createUser(UserRequest userRequest);
    UserResponse getUserById(Long userId);
    UserResponse updateUser(Long userId, UserRequest userRequest);
    List<UserResponse> getAllUsers();
    void deleteUser(Long userId);
}