package dessert;


import dessert.annotations.Cold;
import dessert.annotations.Creamy;
import org.springframework.stereotype.Component;

@Component
@Cold
@Creamy
public class IceCream implements Dessert {
}