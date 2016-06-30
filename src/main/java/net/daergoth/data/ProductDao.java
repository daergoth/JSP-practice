package net.daergoth.data;

import java.util.List;

import net.daergoth.model.Product;

public interface ProductDao {
    
    public List<Product> getAllProducts();
    
    public Product getProductByName(String name);
    
}
