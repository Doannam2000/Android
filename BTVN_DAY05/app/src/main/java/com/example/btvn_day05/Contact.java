package com.example.btvn_day05;

import java.io.Serializable;

public class Contact implements Serializable {

    String name;


    public Contact(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
