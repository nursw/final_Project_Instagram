package start.final_project_instagram.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import start.final_project_instagram.enums.Role;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_gen")
    @SequenceGenerator(sequenceName = "user_seq", name = "user_gen")
    Long id;
    String username;
    String password;
    String email;
    String phoneNumber;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    UserInfo userInfo;
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    Follower follower;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Post> posts;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Comment> comments;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Like> likes;
}