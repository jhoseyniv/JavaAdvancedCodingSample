package com.objectimmutablity;

import java.awt.*;
import java.util.Objects;

public class Car {

    private final String name;
    private final Color color;

    public Car(String name, Color color) {
        if (name == null) {
            throw new NullPointerException("Car name cannot be null");
        }
        this.name = name;
        this.color = Objects.requireNonNull(color,"Car color cannot be null");
    }
}
