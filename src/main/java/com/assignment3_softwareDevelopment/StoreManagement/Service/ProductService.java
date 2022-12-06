package com.assignment3_softwareDevelopment.StoreManagement.Service;

import com.assignment3_softwareDevelopment.StoreManagement.Model.Product;

import java.util.List;


public interface ProductService {

    void saveProduct(Product p);
    List<Product> getAll();
    void deleteProduct(String id);
    Product findById(String id);
    boolean isPresent(String id);
    Product getProdToUpdate(String id);
}
