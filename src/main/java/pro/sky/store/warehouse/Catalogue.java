package pro.sky.store.warehouse;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository
public final class Catalogue {
    private final ArrayList<Product> goods = new ArrayList<Product>(Arrays.asList(
            new Product("Apple"),
            new Product("Orange"),
            new Product("Lemon"),
            new Product("Kiwi"),
            new Product("Mango"),
            new Product("Pear")
    ));


    public ArrayList<Product> getGoods() {
        return goods;
    }
}
