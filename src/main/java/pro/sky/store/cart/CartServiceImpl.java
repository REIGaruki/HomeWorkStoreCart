package pro.sky.store.cart;

import org.springframework.web.context.annotation.SessionScope;
import pro.sky.store.warehouse.Product;
import pro.sky.store.warehouse.Catalogue;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;

@Service
@SessionScope
public class CartServiceImpl implements CartService{
    private HashSet<Product> cart = new HashSet<Product>();
    @Override
    public ArrayList<Integer> addToCart(ArrayList<Integer> addedGoods) {
        ArrayList<Product> goods = Catalogue.getGoods();
        for (Integer i : addedGoods) {
            for (int j = 0; j < goods.size(); j++) {
                if (i == j) {
                    goods.get(i).setQuantity(goods.get(i).getQuantity() + 1);
                    cart.add(goods.get(i));
                }
            }
        }
        return addedGoods;
    }
    @Override
    public HashSet<Product> viewCart() {
        return cart;
    }

    public CartServiceImpl(HashSet<Product> cart) {
        this.cart = cart;
    }
}
