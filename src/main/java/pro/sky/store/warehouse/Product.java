package pro.sky.store.warehouse;

import java.util.Objects;

public class Product {
    private String productName;
    private int quantity;

    public Product(String productName) {
        this.productName = productName;
        this.quantity = 0;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        ///Объекты класса Product эквивалентны, если у них одинаковы поля productName
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
