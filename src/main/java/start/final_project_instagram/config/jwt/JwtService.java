package start.final_project_instagram.config.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.repositories.UserRepository;

import java.time.ZonedDateTime;
@Component
public class JwtService {
    @Value("${security.secret.key}")
    private String secretKey;

    private final UserRepository userRepo;
    private Algorithm algorithm;

    public JwtService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @PostConstruct
    public void init() {
        this.algorithm = Algorithm.HMAC256(secretKey);
    }

    public String generateToken(User user) {
        ZonedDateTime now = ZonedDateTime.now();
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole().name()) // Роль теперь сохраняется корректно
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plusSeconds(100000000).toInstant()) // Оставил, как у тебя
                .sign(algorithm);
    }

    public User verifyToken(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String email = decodedJWT.getClaim("email").asString();

        return userRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found with email: " + email) // Оставил твой RuntimeException
        );
    }
}
