package com.objectimmutablity;

import java.awt.*;
import java.util.Objects;

public class Product {
    private final String name;
    private final Color color;

    public Product(String name, Color color) {
        this.name = Objects.requireNonNullElse(name , " No Name");
        this.color =Objects.requireNonNullElseGet(color ,()-> new Color(6,6,0));

    }
}
