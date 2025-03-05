package start.final_project_instagram.dto;
import lombok.Builder;
import org.springframework.http.HttpStatus;
@Builder
public record SimpleResponse(
        HttpStatus httpStatus,
        String message
) {
}