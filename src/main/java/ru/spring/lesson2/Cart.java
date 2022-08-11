package ru.spring.lesson2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("prototype")
public class Cart {
    private List<Product> list;
    private ProductRepository repository;

    @Autowired
    public void setRepository(ProductRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    private void init(){
        list = new ArrayList<>();
    }

    public void addProductByID(Long id){
        list.add(repository.getProductByID(id));
    }

    public void deleteProductByID(Long id){
        list.remove(repository.getProductByID(id));
    }

    @Override
    public String toString() {
        return list.toString();
    }
}
