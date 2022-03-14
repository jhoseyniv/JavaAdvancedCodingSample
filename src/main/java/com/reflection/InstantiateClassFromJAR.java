package com.reflection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;

public class InstantiateClassFromJAR {

    public static void main(String args[]) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, FileNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        URL[] classLoaderUrls = new URL[] {
                new URL( "file:///D:/Guva/guava-31.0.1-jre.jar")
        };

        URLClassLoader urlClassLoader = new URLClassLoader(classLoaderUrls);
        Class<?> cisClass = urlClassLoader.loadClass("com.google.common.io.CountingInputStream");
        Constructor<?> constructor  = cisClass.getConstructor(InputStream.class);
        Object instance = constructor.newInstance( new FileInputStream(Path.of("D://guva/test.txt").toFile()));
        Method readMethod = cisClass.getMethod("read");
        Method countMethod = cisClass.getMethod("getCount");
        readMethod.invoke(instance);
        Object readBytes = countMethod.invoke(instance);
        System.out.println("Read bytes (should be 1): " + readBytes); //
    }
}
