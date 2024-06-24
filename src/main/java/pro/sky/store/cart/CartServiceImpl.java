package pro.sky.store.cart;

import org.springframework.web.context.annotation.SessionScope;
import pro.sky.store.warehouse.Product;

import org.springframework.stereotype.Service;

import java.util.*;
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
    public Map<Product, Integer> addToCart(List<Integer> addedGoods) {
        Map<Product, Integer> bag = new HashMap<>();
        for (Integer addedGood : addedGoods) {
            if (!bag.containsKey(products.get(addedGood))) {
                bag.put(products.get(addedGood), 1);
                cart.put(products.get(addedGood), 1);
            } else {
                bag.merge(products.get(addedGood), 1, Integer::sum);
                cart.merge(products.get(addedGood), 1, Integer::sum);
            }
        }
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
