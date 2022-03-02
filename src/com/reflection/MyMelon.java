package com.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyMelon {

    private String type;
    private int weight;
    private boolean ripe;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public boolean isRipe() {
        return ripe;
    }

    public void setRipe(boolean ripe) {
        this.ripe = ripe;
    }

    public static void main(String args[]) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("com.reflection.MyMelon");
        Method[] methods = clazz.getDeclaredMethods();
        Arrays.stream(methods).filter(method -> method.getName().startsWith("get") || method.getName().startsWith("is")
                        || method.getName().startsWith("set")).forEach(System.out::println);

    }
}
