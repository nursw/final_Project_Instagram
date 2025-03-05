package start.final_project_instagram.config.swaggerConfig;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import java.util.Collections;
public class Swagger {
    private final String API_KEY = "Bearer Token";
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components()
                        .addSecuritySchemes(API_KEY, apiKeySecurityScheme()))
                .info(new Info().title("Instagram").description("Java 16 beast"))
                .security(Collections.singletonList(new SecurityRequirement().addList(API_KEY)));
    }
    public SecurityScheme apiKeySecurityScheme() {
        return new SecurityScheme()
                .name(API_KEY)
                .description("Please put the token")
                .in(SecurityScheme.In.HEADER)
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer");
    }
}