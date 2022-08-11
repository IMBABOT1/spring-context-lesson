package ru.spring.lesson2;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;

    @PostConstruct
    private void init(){
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Bread", 30),
                new Product(2l, "Milk", 50),
                new Product(3l, "Cheese", 100),
                new Product(4l, "Apples", 70),
                new Product(5l, "Orange", 100)
        ));
    }

    public List getAllProducts(){
        return products;
    }

    public Product getProductByID(Long id){
        for (Product p: products){
            if (p.getId().equals(id)){
                return p;
            }
        }
        throw new RuntimeException("Product not found");
    }
}
