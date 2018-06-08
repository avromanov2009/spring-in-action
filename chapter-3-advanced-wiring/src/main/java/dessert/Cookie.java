package dessert;

import dessert.annotations.Biscuit;
import org.springframework.stereotype.Component;

@Component
@Biscuit
public class Cookie implements Dessert {
}