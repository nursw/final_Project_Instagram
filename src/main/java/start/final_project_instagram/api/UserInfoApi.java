package start.final_project_instagram.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.final_project_instagram.dto.request.ImageRequest;
import start.final_project_instagram.dto.request.UserInfoRequest;
import start.final_project_instagram.dto.response.UserInfoResponse;
import start.final_project_instagram.service.UserInfoService;

@RestController
@RequestMapping("/api/users/{userId}/info")
@RequiredArgsConstructor
public class UserInfoApi {
    private final UserInfoService userInfoService;

    // Save user information
    @PostMapping
    public ResponseEntity<UserInfoResponse> saveUserInfo(
            @PathVariable Long userId,
            @RequestBody UserInfoRequest userInfoRequest) {
        UserInfoResponse userInfoResponse = userInfoService.saveUserInfo(userInfoRequest, userId);
        return new ResponseEntity<>(userInfoResponse, HttpStatus.CREATED);
    }

    // Get user information by user ID
    @GetMapping
    public ResponseEntity<UserInfoResponse> getUserInfo(@PathVariable Long userId) {
        UserInfoResponse userInfoResponse = userInfoService.findUserInfoByUserId(userId);
        return ResponseEntity.ok(userInfoResponse);
    }

    // Update user information
    @PutMapping
    public ResponseEntity<UserInfoResponse> updateUserInfo(
            @PathVariable Long userId,
            @RequestBody UserInfoRequest userInfoRequest) {
        UserInfoResponse userInfoResponse = userInfoService.updateUserInfo(userId, userInfoRequest);
        return ResponseEntity.ok(userInfoResponse);
    }

    // Change user image
    @PutMapping("/image")
    public ResponseEntity<UserInfoResponse> changeImage(
            @PathVariable Long userId,
            @RequestBody ImageRequest imageRequest) {
        UserInfoResponse userInfoResponse = userInfoService.changeImage(userId, imageRequest);
        return ResponseEntity.ok(userInfoResponse);
    }

    // Delete user image
    @DeleteMapping("/image")
    public ResponseEntity<Void> deleteImage(@PathVariable Long userId) {
        userInfoService.deleteImage(userId);
        return ResponseEntity.noContent().build();
    }
}