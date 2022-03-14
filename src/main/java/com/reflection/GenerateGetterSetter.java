package com.reflection;

import java.util.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class GenerateGetterSetter {
    public static void main(String args[]){
        Class<?> clazz = Person.class;

        List<Field> publicFields  = new ArrayList<Field>();
        List<Field> privateFields = new ArrayList<Field>();

        Field[]  fields =clazz.getDeclaredFields();

        for (Field field: fields) {
            if (Modifier.isPublic(field.getModifiers())) {
                publicFields.add(field);
            }
            if (Modifier.isPrivate(field.getModifiers())) {
                privateFields.add(field);
            }
        }

        System.out.println("Print Public Fields  for Class :  " + clazz.getSimpleName());
        publicFields.stream().forEach(System.out::println);

        System.out.println("Print Private Fields  for Class :  " + clazz.getSimpleName());
        privateFields.stream().forEach(System.out::println);

        StringBuilder getters = generateGetters(clazz);
        StringBuilder setters = generateSetters(clazz);

        System.out.println("Getters for class  " + clazz.getSimpleName());
        System.out.println(getters);

        System.out.println("setters for class  " + clazz.getSimpleName());
        System.out.println(setters);




    }


    private static Map<String, Class<?>>  fetchMissingSetters(Class<?> clazz) {
        Map<String, Class<?>> setters = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        String[] names = new String[fields.length];
        Class<?>[] types = new Class<?>[fields.length];
        Arrays.setAll(names, i -> fields[i].getName());
        Arrays.setAll(types, i -> fields[i].getType());
        for (int i = 0; i < names.length; i++) {
            Field field = fields[i];
            boolean finalField = !Modifier.isFinal(field.getModifiers());
            if (finalField) {
                String setterAccessor = fetchSet(names[i]);
                try {
                    Method setter = clazz.getDeclaredMethod(
                            setterAccessor, types[i]);
                    if (setter.getParameterCount() != 1 ||
                            !setter.getReturnType().equals(void.class)) {
                        setters.put(names[i], types[i]);
                        continue;
                    }
                    Parameter parameter = setter.getParameters()[0];
                    if ((parameter.isNamePresent() && !parameter.getName().equals(names[i])) ||
                            !parameter.getType().equals(types[i])) {
                        setters.put(names[i], types[i]);
                    }
                } catch (NoSuchMethodException ex) {
                    setters.put(names[i], types[i]);
// log exception
                }
            }
        }
        return setters;
    }




    private static Map<String, Class<?>> fetchMissingGetters(Class<?> clazz) {
        Map<String, Class<?>> getters = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        String[] names = new String[fields.length];
        Class<?>[] types = new Class<?>[fields.length];
        Arrays.setAll(names, i -> fields[i].getName());
        Arrays.setAll(types, i -> fields[i].getType());
        for (int i = 0; i < names.length; i++) {
            String getterAccessor = fetchIsOrGet(names[i], types[i]);
            try {
                Method getter = clazz.getDeclaredMethod(getterAccessor);
                Class<?> returnType = getter.getReturnType();
                if (!returnType.equals(types[i]) ||
                        getter.getParameterCount() != 0) {
                    getters.put(names[i], types[i]);
                }
            } catch (NoSuchMethodException ex) {
                getters.put(names[i], types[i]);
// log exception
            }
        }
        return getters;
    }

    private static String fetchIsOrGet(String name, Class<?> type) {
        return "boolean".equalsIgnoreCase(type.getSimpleName()) ?
                "is" + uppercase(name) : "get" + uppercase(name);
    }
    private static String fetchSet(String name) {
        return "set" + uppercase(name);
    }
    private static String uppercase(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }
    public static StringBuilder generateGetters(Class<?> clazz) {
        StringBuilder getterBuilder = new StringBuilder();
        Map<String, Class<?>> accessors = fetchMissingGetters(clazz);
        for (Map.Entry<String, Class<?>> accessor: accessors.entrySet()) {
            Class<?> type = accessor.getValue();
            String field = accessor.getKey();
            String getter = fetchIsOrGet(field, type);
            getterBuilder.append("\npublic ")
                    .append(type.getSimpleName()).append(" ")
                    .append(getter)
                    .append("() {\n")
                    .append("\treturn ")
                    .append(field)
                    .append(";\n")
                    .append("}\n");
        }
        return getterBuilder;
    }
    public static StringBuilder generateSetters(Class<?> clazz) {
        StringBuilder setterBuilder = new StringBuilder();
        Map<String, Class<?>> accessors = fetchMissingSetters(clazz);
        for (Map.Entry<String, Class<?>> accessor: accessors.entrySet()) {
            Class<?> type = accessor.getValue();
            String field = accessor.getKey();
            String setter = fetchSet(field);
            setterBuilder.append("\npublic void ")
                    .append(setter)
                    .append("(").append(type.getSimpleName()).append(" ")
                    .append(field).append(") {\n")
                    .append("\tthis.")
                    .append(field).append(" = ")
                    .append(field)
                    .append(";\n")
                    .append("}\n");
        }
        return setterBuilder;
    }
}
