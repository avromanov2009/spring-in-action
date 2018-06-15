package spittr;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import spittr.config.RootConfig;
import spittr.config.WebConfig;

import static org.springframework.boot.SpringApplication.exit;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication(scanBasePackageClasses = { WebConfig.class, RootConfig.class })
public class Chapter5Application {

    public static void main(String[] args) {
        final ConfigurableApplicationContext context = run(Chapter5Application.class, args);

//        System.exit(exit(context, () -> 0));
    }
}