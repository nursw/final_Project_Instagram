package start.final_project_instagram.config.jwt;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import start.final_project_instagram.entities.User;
import start.final_project_instagram.repositories.UserRepository;
import java.time.ZonedDateTime;
@Component
@RequiredArgsConstructor
public class JwtService {
    @Value("${jwt.secret}")
    private String secretKey; // java16
    private final UserRepository userRepo;
    public String generateToken(User user) {
        ZonedDateTime now = ZonedDateTime.now();
        return JWT.create()
                .withClaim("id", user.getId())
                .withClaim("email", user.getEmail())
                .withClaim("role", user.getRole().name())
                .withIssuedAt(now.toInstant())
                .withExpiresAt(now.plusSeconds(100000000).toInstant())
                .sign(getAlgorithm());
    }
    public User verifyToken(String token) {
        Algorithm algorithm = getAlgorithm();
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT decodedJWT = verifier.verify(token);
        String email = decodedJWT.getClaim("email").asString();
        return userRepo.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not found with email: " + email)
        );
    }
    public Algorithm getAlgorithm() {
        return Algorithm.HMAC256(secretKey);
    }
}