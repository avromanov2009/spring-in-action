package app.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import storeservice.ShoppingCart;

import static org.springframework.context.annotation.ScopedProxyMode.INTERFACES;
import static org.springframework.web.context.WebApplicationContext.SCOPE_SESSION;

@Configuration
public class StoreServiceConfig {

    @Scope(value = SCOPE_SESSION, proxyMode = INTERFACES)
    public ShoppingCart shoppingCart() {
        return new ShoppingCart();
    }
}
