package com.reflection;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class WorkingWithArrays {

    public static void main(String args[]){
        int[] arrayOfInt = (int[]) Array.newInstance(int.class,20);
        Person[] personList = (Person[]) Array.newInstance(Person.class,20);
        Array.setInt(arrayOfInt, 0, 100);
        System.out.println("persons list is created.....sucessfully");

    }
}
