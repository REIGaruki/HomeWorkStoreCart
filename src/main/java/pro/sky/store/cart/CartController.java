package pro.sky.store.cart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.store.warehouse.Product;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path="/order")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping(path="/add")
    public Map<Product, Integer> addToCart(@RequestParam(value = "ids") List<Integer> addedGoods) {
        return cartService.addToCart(addedGoods);
    }
    @GetMapping(path="/get")
    public Map<Product, Integer> viewCart() {
        return cartService.getCart();
    }

}
