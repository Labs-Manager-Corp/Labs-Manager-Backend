package lab_manager.com.br.authenticator;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
@Profile("!test")
//TODO: Aplicado Config sem autenticação enquanto não tem servidor jwt tipo keycloak
public class LabManagerAuthConfig {
    
    @Value("${spring.security.oauth2.resourceserver.jwt.audiences}")
    private List<String> audiences;

    // @SuppressWarnings("removal")
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http)
        throws Exception {
        http
                .authorizeHttpRequests(authorize ->
                        authorize
                                // .requestMatchers("*/swagger-ui/**","*/v3/api-docs/**","*/actuator/health/**").permitAll()
                                // .anyRequest().authenticated()
                                .anyRequest().permitAll()
                                );
                // .oauth2ResourceServer(server -> server.jwt());

        return http.build();
        }
}
