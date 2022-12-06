package com.assignment3_softwareDevelopment.StoreManagement.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "stores")
public class Store{

    @Id
    @Column(name = "store_id")
    private String idStore;
    private String address;
    private String city;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    List<ProdDetail> productDetails = new ArrayList<>();

    @OneToMany(mappedBy = "workPlace", cascade = CascadeType.ALL)
    List<Employee> employeesList = new ArrayList<>();



    // Constructor
    public Store() {}

    public Store(String idStore, String address, String city) {
        this.idStore = idStore;
        this.address = address;
        this.city = city;
    }

    public String getIdStore(){return idStore;}

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Employee> getEmployeesList() {
        return employeesList;
    }
}
