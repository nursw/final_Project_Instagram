package start.final_project_instagram.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@Table(name = "likes")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "like_gen")
    @SequenceGenerator(sequenceName = "like_seq", name = "like_gen")
    Long id;
    boolean isLike;
    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = true)
    Post post;
    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = true)
    Comment comment;
    public Like(Object o, Post post, User user) {
    }
}