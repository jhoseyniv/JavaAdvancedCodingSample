package com.designpattern.Creational.Builder;

import com.designpattern.Creational.Builder.model.DiscountItem;
import com.designpattern.Creational.Builder.model.Footer;
import com.designpattern.Creational.Builder.model.Header;
import com.designpattern.Creational.Builder.model.ShoppingItem;

public interface ShoppingCartBuilder {
    ShoppingCartBuilder buildHeader(Header header);
    ShoppingCartBuilder buildItem(ShoppingItem item);
    ShoppingCartBuilder buildDiscount(DiscountItem discountItem);
    ShoppingCartBuilder buildfooter(Footer footer);
}
