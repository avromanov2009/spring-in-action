package config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import soundsystem.BlankDisc;

@Configuration
public class ExpressiveConfig {

    @Autowired
    private Environment environment;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public BlankDisc disc() {
        return new BlankDisc(environment.getProperty("disc.title", "You Know Me"), environment.getProperty("disc" +
                ".artist", "Art Traffic Controller"));
    }
}
