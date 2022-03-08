package com.designpattern.Creational.Builder.model;

public class ShoppingItem {
    private long itemId;
    private  String title;
    private  String numOfOrderd;
    private double price;
    private double fullPrice;

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNumOfOrderd() {
        return numOfOrderd;
    }

    public void setNumOfOrderd(String numOfOrderd) {
        this.numOfOrderd = numOfOrderd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getFullPrice() {
        return fullPrice;
    }

    public void setFullPrice(double fullPrice) {
        this.fullPrice = fullPrice;
    }
}
