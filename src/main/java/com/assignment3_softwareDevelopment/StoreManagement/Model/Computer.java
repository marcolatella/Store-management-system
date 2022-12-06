package com.assignment3_softwareDevelopment.StoreManagement.Model;

import javax.persistence.Entity;

@Entity
public class Computer extends Product{

    private int ram;
    private double inches;
    private boolean ssd;


    //Constructor
    public Computer() {
    }

    public Computer(String id, String name, String brand, int storage, int ram, double inches, boolean ssd) {
        super(id, name, brand, storage);
        this.ram = ram;
        this.inches = inches;
        this.ssd = ssd;
    }

    //Getter and Setter
    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public double getInches() {
        return inches;
    }

    public void setInches(double inches) {
        this.inches = inches;
    }

    public boolean isSsd() {
        return ssd;
    }

    public void setSsd(boolean ssd) {
        this.ssd = ssd;
    }
}
