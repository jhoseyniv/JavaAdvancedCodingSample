package com.designpattern.Creational.Builder.model;

import java.util.List;

public class ShoppingCart {
    private Header header;
    private List<ShoppingItem> items;
    private List<DiscountItem> discounts;
    private Footer footer;

    public void setHeader(Header header) {
        this.header = header;
    }

    public void setItems(List<ShoppingItem> items) {
        this.items = items;
    }

    public void setDiscounts(List<DiscountItem> discounts) {
        this.discounts = discounts;
    }

    public void setFooter(Footer footer) {
        this.footer = footer;
    }

    public List<ShoppingItem> getItems() {
        return items;
    }

    public List<DiscountItem> getDiscounts() {
        return discounts;
    }
}