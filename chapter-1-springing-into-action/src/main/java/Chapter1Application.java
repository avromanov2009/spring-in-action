import knights.Knight;
import knights.config.KnightConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.exit;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackageClasses = KnightConfig.class)
public class Chapter1Application {
    public static void main(String[] args) {
        run(Chapter1Application.class, args);
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        final Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        System.exit(exit(context, () -> 0));
    }
}