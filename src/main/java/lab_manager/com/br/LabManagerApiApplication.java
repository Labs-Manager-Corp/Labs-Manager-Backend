package lab_manager.com.br;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;


@SpringBootApplication
public class LabManagerApiApplication {

	@Value("${project.version}")
    private String apiVersion;

	public static void main(String[] args) {
		SpringApplication.run(LabManagerApiApplication.class, args);
	}

	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Lab Manager API").version(apiVersion).description(
                "[Documentation]()"))
                .addServersItem(new Server().url("/lab-api"))
                .schemaRequirement(apiVersion, null);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();

        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");

        return messageSource;
    }
}
