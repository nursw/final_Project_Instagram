package start.final_project_instagram.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.ImageRequest;
import start.final_project_instagram.dto.request.UserInfoRequest;
import start.final_project_instagram.dto.response.UserInfoResponse;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.entities.UserInfo;
import start.final_project_instagram.repositories.UserInfoRepository;
import start.final_project_instagram.repositories.UserRepository;
import start.final_project_instagram.service.UserInfoService;
@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final UserRepository userRepository;
    @Override
    public UserInfoResponse saveUserInfo(UserInfoRequest userInfoRequest, Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        UserInfo userInfo = new UserInfo();
        userInfo.setFullName(userInfoRequest.fullName());
        userInfo.setBiography(userInfoRequest.biography());
        userInfo.setGender(userInfoRequest.gender());
        userInfo.setImage(userInfoRequest.image());
        userInfo.setUser(user);
        userInfoRepository.save(userInfo);
        return new UserInfoResponse(
                userInfo.getId(),
                userInfo.getFullName(),
                userInfo.getBiography(),
                userInfo.getGender(),
                userInfo.getImage()
        );
    }
    @Override
    public UserInfoResponse findUserInfoByUserId(Long userId) {
        UserInfo userInfo = userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User info not found"));
        return new UserInfoResponse(
                userInfo.getId(),
                userInfo.getFullName(),
                userInfo.getBiography(),
                userInfo.getGender(),
                userInfo.getImage()
        );
    }
    @Override
    public UserInfoResponse updateUserInfo(Long userId, UserInfoRequest userInfoRequest) {
        UserInfo userInfo = userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User info not found"));
        userInfo.setFullName(userInfoRequest.fullName());
        userInfo.setBiography(userInfoRequest.biography());
        userInfo.setGender(userInfoRequest.gender());
        userInfo.setImage(userInfoRequest.image());
        userInfoRepository.save(userInfo);
        return new UserInfoResponse(
                userInfo.getId(),
                userInfo.getFullName(),
                userInfo.getBiography(),
                userInfo.getGender(),
                userInfo.getImage()
        );
    }
    @Override
    public UserInfoResponse changeImage(Long userId, ImageRequest imageRequest) {
        UserInfo userInfo = userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User info not found"));
        userInfo.setImage(imageRequest.imageUrl());
        userInfoRepository.save(userInfo);
        return new UserInfoResponse(
                userInfo.getId(),
                userInfo.getFullName(),
                userInfo.getBiography(),
                userInfo.getGender(),
                userInfo.getImage()
        );
    }
    @Override
    public void deleteImage(Long userId) {
        UserInfo userInfo = userInfoRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User info not found"));
        userInfo.setImage(null);
        userInfoRepository.save(userInfo);
    }
}