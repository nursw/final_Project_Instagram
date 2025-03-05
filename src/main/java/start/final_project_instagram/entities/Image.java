package start.final_project_instagram.entities;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Entity
@Getter
@Setter
@Table(name = "images")
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_gen")
    @SequenceGenerator(sequenceName = "image_seq", name = "image_gen")
    Long id;
    String imageUrl;
    @ManyToOne
    @JoinColumn(name = "post_id")
    Post post;
}