import app.config.DataSourceConfig;
import app.config.DessertConfig;
import app.config.MagicBeanConfig;
import dessert.Dessert;
import dessert.annotations.Cold;
import dessert.annotations.Creamy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import static org.springframework.boot.SpringApplication.exit;
import static org.springframework.boot.SpringApplication.run;

@SpringBootApplication
@ComponentScan(basePackageClasses = {DataSourceConfig.class, MagicBeanConfig.class, DessertConfig.class})
public class Chapter3Application {

    @Autowired
    @Cold
    @Creamy
    private Dessert dessert;

    public static void main(String[] args) {
        run(Chapter3Application.class, args);
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class, MagicBeanConfig.class, MagicBeanConfig.class);

        System.exit(exit(context, () -> 0));
    }
}