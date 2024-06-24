package pro.sky.store.cart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.store.warehouse.Product;

import java.util.ArrayList;
import java.util.HashSet;

@RestController
@RequestMapping(path="/order")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path="/add")
    public ArrayList<Integer> addToCart(@RequestParam(value = "ids") ArrayList<Integer> addedGoods) {
        return cartService.addToCart(addedGoods);
    }
    @GetMapping(path="/get")
    public HashSet<Product> viewCart() {
        return cartService.viewCart();
    }
}
