package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.servlet.ServletContext;

import static org.springframework.context.annotation.FilterType.ANNOTATION;

@Configuration
@ComponentScan(basePackages = "spittr", excludeFilters = @ComponentScan.Filter(type = ANNOTATION, value = EnableWebMvc.class))
public class RootConfig {

    @Bean
    public ServletContext servletContext() {
        return new MockServletContext();
    }
}