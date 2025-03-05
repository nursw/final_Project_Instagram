package start.final_project_instagram.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "followers")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Follower {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "follower_gen")
    @SequenceGenerator(sequenceName = "follower_seq", name = "follower_gen")
    Long id;
    @ManyToMany
    @JoinTable(name = "user_followers",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"))
    List<User> subscribers;
    @ManyToMany
    @JoinTable(name = "user_subscriptions",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subscription_id"))
    List<User> subscriptions;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
    public Follower(User user, Object o, Object o1) {
    }
}