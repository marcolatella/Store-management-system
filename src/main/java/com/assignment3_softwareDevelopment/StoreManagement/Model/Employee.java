package com.assignment3_softwareDevelopment.StoreManagement.Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    @Column(name = "employee_id")
    private String id;
    private String name;
    private String surname;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "store_id")
    private Store workPlace;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @OneToMany(mappedBy = "manager", cascade = CascadeType.ALL)
    List<Employee> subordinates = new ArrayList<>();

    //Constructors
    public Employee(){
    }

    public Employee(String id, String name, String surname, Store workPlace, Employee manager) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workPlace = workPlace;
        this.manager = manager;
    }

    //Getter and Setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Store getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(Store workPlace) {
        this.workPlace = workPlace;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }
}