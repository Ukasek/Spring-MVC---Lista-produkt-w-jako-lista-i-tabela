package com.example.demo.lista;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Products> productList = new ArrayList<>();

    public List<Products> getAll() {
        return productList;
    }

    public void add(Products products) {
        productList.add(products);
    }
}
