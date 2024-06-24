package pro.sky.store.cart;

import org.springframework.web.context.annotation.SessionScope;
import pro.sky.store.warehouse.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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
    public Map<Product, Integer> addToCart(List<Integer> addedGoods) {
        Map<Product, Integer> bag = addedGoods.stream()
                .collect(Collectors.toMap(
                        i -> products.get(i),
                        1,
                        Integer::sum
                ));
        cart.putAll(bag);
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
