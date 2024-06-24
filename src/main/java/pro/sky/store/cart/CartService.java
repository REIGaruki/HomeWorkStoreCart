package pro.sky.store.cart;

import pro.sky.store.warehouse.Product;

import java.util.ArrayList;
import java.util.HashSet;

public interface CartService {
    ArrayList<Integer> addToCart(ArrayList<Integer> addedGoods);

    HashSet<Product> getCart();

    ArrayList<Product> getCatalogue();
}