package pro.sky.store.warehouse;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public final class Catalogue {
    private final ArrayList<Product> goods = new ArrayList<Product>(Arrays.asList(
            new Product("Apple", 300),
            new Product("Orange", 200),
            new Product("Lemon", 200),
            new Product("Kiwi", 200),
            new Product("Mango",400),
            new Product("Pear",250)
    ));


    public ArrayList<Product> getGoods() {
        return goods;
    }
}
