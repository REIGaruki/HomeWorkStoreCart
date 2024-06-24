package pro.sky.store.cart;

import pro.sky.store.warehouse.Product;

import java.util.List;
import java.util.Map;

public interface CartService {
    Map<Product, Integer> addToCart(List<Integer> addedGoods);

    Map<Product, Integer> getCart();
}