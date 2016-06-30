package net.daergoth.data;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import net.daergoth.model.Product;

public class ProductDaoMock implements ProductDao {

    private static final List<Product> products = Arrays.asList(
            new Product("Chocolate Cookie", 10, LocalDate.now().minusDays(1)),
            new Product("Cheese Cake", 15, LocalDate.now().minusDays(2)),
            new Product("Ice-Cream Sandwich", 5, LocalDate.now().minusDays(4)),
            new Product("Strawberry Donut", 7, LocalDate.now().minusDays(1)),
            new Product("Crispy Marshmallow", 13, LocalDate.now().minusWeeks(2))
    );
    
    public List<Product> getAllProducts() {
        return products;
    }

    public Product getProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        
        return null;
    }

}
