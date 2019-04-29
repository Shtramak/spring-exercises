package ua.procamp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * This class provides web (servlet) related configuration.
 * <p>
 * todo: 1. Mark this class as Spring config class
 * todo: 2. Enable web mvc using annotation
 * todo: 3. Enable component scanning for package "web" using annotation value
 * todo: 4. Configure JPS internal view resolver with prefix = "/WEB-INF/views/" and suffix ".jsp"
 */

@Configuration
@ComponentScan("ua.procamp.web")
@EnableWebMvc
public class WebConfig {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
}
