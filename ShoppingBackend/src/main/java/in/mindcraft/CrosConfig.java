package in.mindcraft;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrosConfig 
{
	 @Bean
    public WebMvcConfigurer corsConfigurer() 
    {
        return new WebMvcConfigurer() 
        {
            @Override
            public void addCorsMappings(CorsRegistry registry) 
            {
                registry.addMapping("/**") // Allow all endpoints
                        .allowedOrigins("http://localhost:4200") // Adjust the origin as needed
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH") // Add the HTTP methods you want to allow
                        .allowCredentials(true);
            }
        };
    }
}
