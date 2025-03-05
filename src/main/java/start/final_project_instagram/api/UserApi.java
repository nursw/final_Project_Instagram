package start.final_project_instagram.api;

import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import start.final_project_instagram.dto.request.UserRequest;
import start.final_project_instagram.dto.response.UserResponse;
import start.final_project_instagram.service.UserService;
import java.util.List;
@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserApi {
    private final UserService userService;

    // Sign up new user
    @PostMapping("/sign-up")
    public ResponseEntity<UserResponse> signUp(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.signUp(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Sign in existing user
    @PostMapping("/sign-in")
    public ResponseEntity<UserResponse> signIn(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.signIn(userRequest);
        return ResponseEntity.ok(userResponse);
    }

    // Get user profile
    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getUserProfile(Authentication authentication) {
        // Assuming the user ID is part of the authentication details (e.g., JWT token)
        Long userId = Long.parseLong(authentication.name());  // Adjust this based on your auth system
        UserResponse userResponse = userService.getUserProfile(userId);
        return ResponseEntity.ok(userResponse);
    }

    // Create a new user (Admin/Other roles)
    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.createUser(userRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Get user by ID
    @GetMapping("/{userId}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long userId) {
        UserResponse userResponse = userService.getUserById(userId);
        return ResponseEntity.ok(userResponse);
    }

    // Update user information
    @PutMapping("/{userId}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long userId, @RequestBody UserRequest userRequest) {
        UserResponse userResponse = userService.updateUser(userId, userRequest);
        return ResponseEntity.ok(userResponse);
    }

    // Delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    // Get all users (Admin)
    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> userResponses = userService.getAllUsers();
        return ResponseEntity.ok(userResponses);
    }
}