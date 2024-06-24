package pro.sky.store.cart;

import org.springframework.web.context.annotation.SessionScope;
import pro.sky.store.warehouse.Product;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@SessionScope
public class CartServiceImpl implements CartService{
    private Map<Product, Integer> cart;
    private final List<Product> products = new ArrayList<Product>(Arrays.asList(
            new Product("Apple"),
            new Product("Orange"),
            new Product("Lemon"),
            new Product("Kiwi"),
            new Product("Mango"),
            new Product("Pear")
    ));
    @Override
    public Map<Product, Integer> addToCart(List<Integer> ids) {
        Map<Product, Integer> bag = ids.stream().collect(Collectors.toMap(
                products::get,
                i -> 1,
                Integer::sum
        ));
        cart = Stream.concat(bag.entrySet().stream(), cart.entrySet().stream()).collect(Collectors.toMap(
                entry -> entry.getKey(),
                entry -> entry.getValue(),
                (a, b) -> Integer.sum(a, b)
        ));
        return bag;
    }

    public CartServiceImpl(Map<Product, Integer> cart) {
        this.cart = cart;
    }

    @Override
    public Map<Product, Integer> getCart() {
        return cart;
    }
}
