package com.designpattern.Creational.Builder;

import com.designpattern.Creational.Builder.model.*;

import java.util.ArrayList;
import java.util.List;

public class ConcreteShoppingCartBuilder implements ShoppingCartBuilder {
    private ShoppingCart cart;

    public ConcreteShoppingCartBuilder() {
        this.cart = new ShoppingCart();
    }


    @Override
    public ShoppingCartBuilder buildHeader(Header header) {
        cart.setHeader(header);
        return this;
    }

    @Override
    public ShoppingCartBuilder buildItem(ShoppingItem item) {
        List<ShoppingItem> items = new ArrayList<ShoppingItem>();
        items.add(item);
        cart.setItems(items);
        return this;
    }

    @Override
    public ShoppingCartBuilder buildDiscount(DiscountItem discountItem) {
        List<DiscountItem> discountItems = new ArrayList<DiscountItem>();
        discountItems.add(discountItem);
        cart.setDiscounts(discountItems);
        return this;
    }

    @Override
    public ShoppingCartBuilder buildfooter(Footer footer) {
        cart.setFooter(footer);
        return this;
    }
}
