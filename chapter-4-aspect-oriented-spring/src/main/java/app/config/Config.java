package app.config;

import app.concert.Audience;
import app.concert.EncoreableIntroducer;
import app.concert.Performance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
public class Config {

    @Bean
    public Audience audience() {
        return new Audience();
    }

    @Bean
    public Performance performance() {
        return new Performance();
    }

    @Bean
    public EncoreableIntroducer encoreableIntroducer() {
        return new EncoreableIntroducer();
    }
}