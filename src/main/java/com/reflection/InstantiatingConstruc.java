package com.reflection;

import com.designpattern.Creational.Singleton;

import java.awt.*;
import java.lang.reflect.*;
import java.util.Arrays;

public class InstantiatingConstruc {

    public static void main(String args[]) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<MyCar> clazz = MyCar.class;
        Constructor<MyCar> emptyCnstr  = clazz.getConstructor();
        Constructor<MyCar> idNameCnstr = clazz.getConstructor(int.class,String.class);
        Constructor<MyCar> idColorCnstr = clazz.getConstructor(int.class, Color.class);
        Constructor<MyCar> idNameColorCnstr = clazz.getConstructor(int.class, String.class, Color.class);

        MyCar carWithEmptyConstructore = emptyCnstr.newInstance();

        MyCar carViaIdNameCnstr = idNameCnstr.newInstance(1, "Dacia");
        MyCar carViaIdColorCnstr = idColorCnstr.newInstance(1, new Color(0, 0, 0));
        MyCar carViaIdNameColorCnstr = idNameColorCnstr.newInstance(1, "Dacia", new Color(0, 0, 0));

        //create instance from a private constructor
        Class<Singleton> singletonClass = Singleton.class;
       // Constructor<Singleton> singletonConstructor = singletonClass.getConstructor();
      //  Singleton singleton =  singletonConstructor.newInstance();
        System.out.println("new instance from singltone class from private constuctor by reflection---->" + singletonClass);

        //list of constructors
        Class<MyCar> clazzMyCar = MyCar.class;
        Constructor<?>[] cnstrs = clazz.getConstructors();
        System.out.println("My Car class has " + cnstrs.length + " constructors");
        Arrays.stream(cnstrs).forEach(System.out::println);

        //number of each constructor parameter
        for (Constructor<?> cnstr : cnstrs) {
            int paramCount = cnstr.getParameterCount();
            System.out.println("\nConstructor with " + paramCount + " parameters");
        }

        //type  of each parameter
        for (Constructor<?> cnstr : cnstrs) {
            Class<?>[] typesOfParams = cnstr.getParameterTypes();

        }



    }


}
