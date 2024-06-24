package pro.sky.store.cart;

import org.springframework.web.context.annotation.SessionScope;
import pro.sky.store.warehouse.Product;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@Service
@SessionScope
public class CartServiceImpl implements CartService{
    private HashSet<Product> cart = new HashSet<Product>();
    private final ArrayList<Product> catalogue = new ArrayList<Product>(Arrays.asList(
            new Product("Apple"),
            new Product("Orange"),
            new Product("Lemon"),
            new Product("Kiwi"),
            new Product("Mango"),
            new Product("Pear")
    ));
    @Override
    public ArrayList<Integer> addToCart(ArrayList<Integer> addedGoods) {
        for (Integer i : addedGoods) {
            for (int j = 0; j < catalogue.size(); j++) {
                System.out.println(i);
                if (i == j) {
                    catalogue.get(i).setQuantity(catalogue.get(i).getQuantity() + 1);
                    cart.add(catalogue.get(i));
                }
            }
        }
        return addedGoods;
    }

    public CartServiceImpl(HashSet<Product> cart) {
        this.cart = cart;
    }

    public HashSet<Product> getCart() {
        return cart;
    }

    public ArrayList<Product> getCatalogue() {
        return catalogue;
    }
}
