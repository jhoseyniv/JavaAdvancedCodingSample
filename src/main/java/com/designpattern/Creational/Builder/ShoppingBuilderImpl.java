package com.designpattern.Creational.Builder;

import com.designpattern.Creational.Builder.model.*;

public class ShoppingBuilderImpl {
    public static void main(String args[]){
        ShoppingCartBuilder shoppingCart = new ConcreteShoppingCartBuilder().buildHeader(new Header("one","10",null)).
        buildItem(new ShoppingItem()).buildDiscount(new DiscountItem()).buildfooter(new Footer());
        System.out.println(shoppingCart.getClass());
    }
}
