package config;

import dessert.Cake;
import dessert.Dessert;
import dessert.IceCream;
import dessert.annotations.Cold;
import dessert.annotations.Creamy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DessertConfig {

    @Bean
    @Cold
    @Creamy
    @Primary
    public Dessert iceCream() {
        return new IceCream();
    }

    @Bean
    @Primary
    public Dessert cake() {
        return new Cake();
    }

}