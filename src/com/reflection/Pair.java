package com.reflection;

import com.objectimmutablity.Car;

import java.awt.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

public final class Pair<L, R> extends Car implements Comparable {
    final L left;
    final R right;
    public Pair(L left, R right) {
        super("BMW",new Color(10));
        this.left = left;
        this.right = right;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public class Entry<L, R> {}


    public static void main(String args[]) throws ClassNotFoundException {
        Pair pair = new Pair(1, 1);



        //get name of pair
        Class<?> clazz = pair.getClass();
        System.out.println("Name: " + clazz.getName());

        // Pair
        System.out.println("Simple name: " + clazz.getSimpleName());

        System.out.println("Canonical name: " + clazz.getCanonicalName());

        Class<Pair> clazz2 = Pair.class;
        Class<?> clazz3 = Class.forName("com.reflection.Pair");

        //Getting the Pair class modifiers
        int modifiers = clazz3.getModifiers();

        System.out.println("Is public? "   + Modifier.isPublic(modifiers)); // true
        System.out.println("Is final? "    + Modifier.isFinal(modifiers)); // true
        System.out.println("Is abstract? " + Modifier.isAbstract(modifiers)); // false

        //get interfaces
        Class<?>[] interfaces = clazz3.getInterfaces();
        Arrays.stream(interfaces).forEach(System.out::println);

        //get fields
        Field[]  fields =clazz3.getDeclaredFields();
        Arrays.stream(fields).forEach(System.out::println);


        //get parent
        System.out.println("parent  name:------------> " + clazz3.getSuperclass());


        // get final or immutable calss
        System.out.println("super class Type  name:------------> " + clazz3.getGenericSuperclass());

        // Generics of interfaces
        Type[] interfacesTypes = clazz.getGenericInterfaces();


        //get Methods
        System.out.println("get Method Names:--------------> " );
        Method[] methods = clazz3.getMethods();
        Arrays.stream(methods).forEach(System.out::println);

        //get modules
        System.out.println("get class modules:--------------> " + clazz3.getModule().getName());


        // public final class modern.challenge.Pair<L,R>
        System.out.println("Description of Pair: " + clazz3.toGenericString());

        // Lmodern/challenge/Pair;
        System.out.println("Type descriptor of Pair: " + clazz.descriptorString());

        // Ljava/lang/String;
        System.out.println("Type descriptor of String: " + String.class.descriptorString());

        Class<?> arrayClazz = clazz.arrayType();
        // modern.challenge.Pair<L,R>[]
        System.out.println("Array type: " + arrayClazz.toGenericString());
    }



}