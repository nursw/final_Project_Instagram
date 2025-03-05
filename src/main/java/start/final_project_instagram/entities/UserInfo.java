package start.final_project_instagram.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import start.final_project_instagram.enums.Gender;
@Entity
@Getter
@Setter
@Table(name = "userInfo")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "userInfo_gen")
    @SequenceGenerator(sequenceName = "userInfo_seq", name = "userInfo_gen")
    Long id;
    String fullName;
    String biography;
    Gender gender;
    String image;
    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}