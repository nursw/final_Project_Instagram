package start.final_project_instagram.service.serviceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import start.final_project_instagram.dto.request.UserRequest;
import start.final_project_instagram.dto.response.UserResponse;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.repositories.UserRepository;
import start.final_project_instagram.service.UserService;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public UserResponse signUp(UserRequest userRequest) {
        Optional<User> existingUser = userRepository.findByEmail(userRequest.email());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Email уже используется!");
        }
        existingUser = userRepository.findByUsername(userRequest.username());
        if (existingUser.isPresent()) {
            throw new IllegalStateException("Username уже используется!");
        }
        User user = new User();
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        User savedUser = userRepository.save(user);
        return new UserResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getPhoneNumber()
        );
    }
    @Override
    public UserResponse signIn(UserRequest userRequest) {
        User user = userRepository.findByEmail(userRequest.email())
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь с таким email не найден"));
        if (!passwordEncoder.matches(userRequest.password(), user.getPassword())) {
            throw new BadCredentialsException("Неверный пароль");
        }
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPhoneNumber());
    }
    @Override
    public UserResponse getUserProfile(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPhoneNumber());
    }
    @Override
    public UserResponse createUser(UserRequest userRequest) {
        if (userRepository.findByEmail(userRequest.email()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует");
        }
        if (userRepository.findByUsername(userRequest.username()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким username уже существует");
        }
        User user = new User();
        user.setUsername(userRequest.username());
        user.setPassword(passwordEncoder.encode(userRequest.password()));
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail(), savedUser.getPhoneNumber());
    }
    @Override
    public UserResponse getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        return new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getPhoneNumber());
    }
    @Override
    public UserResponse updateUser(Long userId, UserRequest userRequest) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        if (!user.getUsername().equals(userRequest.username()) &&
                userRepository.findByUsername(userRequest.username()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким username уже существует");
        }
        if (!user.getEmail().equals(userRequest.email()) &&
                userRepository.findByEmail(userRequest.email()).isPresent()) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует");
        }
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setPhoneNumber(userRequest.phoneNumber());
        if (!userRequest.password().isBlank()) {
            user.setPassword(passwordEncoder.encode(userRequest.password()));
        }
        User updatedUser = userRepository.save(user);
        return new UserResponse(updatedUser.getId(), updatedUser.getUsername(), updatedUser.getEmail(), updatedUser.getPhoneNumber());
    }
    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UsernameNotFoundException("Пользователь не найден"));
        userRepository.delete(user);
    }
    @Override
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getPhoneNumber()))
                .toList();
    }
}