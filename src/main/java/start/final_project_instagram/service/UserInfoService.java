package start.final_project_instagram.service;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.ImageRequest;
import start.final_project_instagram.dto.request.UserInfoRequest;
import start.final_project_instagram.dto.response.UserInfoResponse;
@Service
public interface UserInfoService {
    UserInfoResponse saveUserInfo(UserInfoRequest userInfoRequest, Long userId);
    UserInfoResponse findUserInfoByUserId(Long userId);
    UserInfoResponse updateUserInfo(Long userId, UserInfoRequest userInfoRequest);
    UserInfoResponse changeImage(Long userId, ImageRequest imageRequest);
    void deleteImage(Long userId);
}