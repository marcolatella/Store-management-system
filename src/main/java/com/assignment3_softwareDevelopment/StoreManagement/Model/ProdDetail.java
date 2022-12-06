package com.assignment3_softwareDevelopment.StoreManagement.Model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "product_details")
public class ProdDetail implements Serializable {
    @Id
    @Column(name = "product_detail_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "product_id")
    private Product product;


    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "store_id")
    private Store store;


    private int quantity;
    private double price;


    public ProdDetail() {
    }

    public ProdDetail(Product product, Store store, int quantity, double price) {
        this.product = product;
        this.store = store;
        this.quantity = quantity;
        this.price = price;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) { this.price = price; }
}
