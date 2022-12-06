package com.assignment3_softwareDevelopment.StoreManagement.Model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
public class Smartphone extends Product{

    @NotBlank(message = "Color field is required!")
    private String color;
    private boolean fiveG;

    //Constructor
    public Smartphone(){
    }

    public Smartphone(String id, String name, String brand, int storage, String color, boolean fiveG) {
        super(id, name, brand, storage);
        this.color = color;
        this.fiveG = fiveG;
    }


    //Getter and Setter
    public boolean isFiveG() {
        return fiveG;
    }

    public void setFiveG(boolean fiveG) { this.fiveG = fiveG; }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
