package com.assignment3_softwareDevelopment.StoreManagement.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    private String code;
    private String name;
    private String brand;
    private int storage;

    @OneToMany(mappedBy = "product", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    List<ProdDetail> productDetails = new ArrayList<>();

    //Constructors
    public Product(){
    }

    public Product(String code, String name, String brand, int storage) {
        this.code = code;
        this.name = name;
        this.brand = brand;
        this.storage = storage;
    }

    //Getter and Setter Method
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) { this.brand = brand; }

    public void add(ProdDetail p){
        this.productDetails.add(p);
    }

    public void delete(int id){
        this.productDetails.remove(id);
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public List<ProdDetail> getProductDetails() {
        return productDetails;
    }
}

