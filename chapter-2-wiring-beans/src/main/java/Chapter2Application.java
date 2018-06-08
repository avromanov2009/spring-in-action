import soundsystem.CDPlayerConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.exit;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackageClasses = CDPlayerConfig.class)
public class Chapter2Application {
    public static void main(String[] args) {
        run(Chapter2Application.class, args);
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CDPlayerConfig.class);

        System.exit(exit(context, () -> 0));
    }
}