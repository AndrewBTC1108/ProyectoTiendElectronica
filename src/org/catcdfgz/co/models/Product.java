package org.catcdfgz.co.models;

public class Product extends BaseProduct {
    private String name;
    private String description;
    private double price;
    private int amount;

    public Product(String name, String description, double price, int amount) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.amount = amount;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return STR."id=\{id}name='\{name}\{'\''}, description='\{description}\{'\''}, price=\{price}, amount=\{amount}";
    }
}
