package com.designpattern.Creational.Single;

import com.designpattern.Creational.ClassicSingleton;

public class TestSingletone {

    public static void main(String args[]){
        System.out.println(" class 1 = " + ClassicSingleton.getInstance());
        System.out.println(" class 2 = " + ClassicSingleton.getInstance());
        System.out.println(" class 3 = " + ClassicSingleton.getInstance());
        System.out.println(" class 4 = " + ClassicSingleton.getInstance());
        System.out.println(" class 5 = " + ClassicSingleton.getInstance());

    }
}
