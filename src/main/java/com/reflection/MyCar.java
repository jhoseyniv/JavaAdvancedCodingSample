package com.reflection;

import java.awt.*;

public class MyCar {

    private int id;
    private String name;
    private Color color;
    public MyCar() {}
    public MyCar(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public MyCar(int id, Color color) {
        this.id = id;
        this.color = color;
    }
    public MyCar(int id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
