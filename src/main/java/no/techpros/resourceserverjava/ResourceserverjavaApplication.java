package no.techpros.resourceserverjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.oauth2.resourceserver.OAuth2ResourceServerSecurityMarker;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ResourceserverjavaApplication {

    public static void main(String[] args) {

		SpringApplication.run(ResourceserverjavaApplication.class, args);
    }

   /* @Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins(new String[]{"http://localhost:9000"}).allowedMethods("PUT", "DELETE", "GET", "POST",
						"HEAD");
			}

		};
	}*/
}
