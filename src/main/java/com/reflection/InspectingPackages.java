package com.reflection;

import com.objectimmutablity.Car;

import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InspectingPackages {

    public static final String PERFIX="sun";

    public static void main(String args[]) throws ClassNotFoundException {


        Class clazz = Class.forName("java.lang.Integer");
        Package packageOfClazz = clazz.getPackage();
        //java.lang
        System.out.println(packageOfClazz.getName());


        File file = new File(".");
        Package packageOfFile = file.getClass().getPackage();
        // java.io
        String packageNameOfFile = packageOfFile.getName();
        System.out.println(packageNameOfFile);

        Package[] packages = Package.getPackages();
        //Arrays.stream(packages).forEach(System.out::println);



        var packageList = fetchPackagesByPrefix(InspectingPackages.PERFIX);
        packageList.stream().forEach(System.out::println);

        Car merceds =  new Car("S500", new Color(0));

        Class<?> clazzCar = Class.forName(merceds.getClass().getModule(), "com.objectimmutablity.Car");
        System.out.println(clazzCar);


    }

    public static List<String> fetchPackagesByPrefix(String prefix) {
        return Arrays.stream(Package.getPackages())
                .map(Package::getName)
                .filter(n -> n.startsWith(prefix))
                .collect(Collectors.toList());
    }



}
