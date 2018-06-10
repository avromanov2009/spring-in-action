package app;

import app.config.Config;
import app.config.TrackCounterConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.springframework.boot.SpringApplication.exit;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackageClasses = {Config.class, TrackCounterConfig.class})
public class Chapter4Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = run(Chapter4Application.class, args);

        System.exit(exit(context, () -> 0));
    }
}