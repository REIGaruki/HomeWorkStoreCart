package pro.sky.store.cart;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pro.sky.store.warehouse.Product;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class CartServiceImplTest {
    private final Map<Product, Integer> cart = new HashMap<>();
    private final CartService sut = new CartServiceImpl(cart);

    @Test
    void addToCart() {
        Map<Product, Integer> bag1 = sut.addToCart(Arrays.asList(1,2,4));
        Map<Product, Integer> bag2 = sut.addToCart(Arrays.asList(1,2,4,4));
        Map<Product, Integer> actual = sut.getCart();
        Map<Product, Integer> expected = new HashMap<>();
        expected.put(new Product("Orange"), 2);
        expected.put(new Product("Lemon"), 2);
        expected.put(new Product("Mango"), 3);
        Assertions.assertEquals(expected, actual);
        Assertions.assertNotEquals(bag1,bag2);
    }

}