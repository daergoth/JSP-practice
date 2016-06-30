package net.daergoth.model;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable{

    private static final long serialVersionUID = 960469063159618518L;

    private String name;
    
    private float price;
    
    private LocalDate productionTime;

    public Product() {
        super();
    }

    public Product(String name, float price, LocalDate productionTime) {
        super();
        this.name = name;
        this.price = price;
        this.productionTime = productionTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(LocalDate productionTime) {
        this.productionTime = productionTime;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + Float.floatToIntBits(price);
        result = prime * result + ((productionTime == null) ? 0 : productionTime.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Product other = (Product) obj;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
            return false;
        if (productionTime == null) {
            if (other.productionTime != null)
                return false;
        } else if (!productionTime.equals(other.productionTime))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", productionTime=" + productionTime + "]";
    }
    
    
    
}
