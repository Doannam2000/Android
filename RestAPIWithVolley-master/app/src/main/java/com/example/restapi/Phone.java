package com.example.restapi;

public class Phone {
    private String id;
    private String name;
    private String description;
    private String price;
    private String total;

    public Phone() {

    }
    public Phone(String id, String name, String description, String price, String total) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.total = total;
    }

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Phone{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price='" + price + '\'' +
                ", total='" + total + '\'' +
                '}';
    }
}
