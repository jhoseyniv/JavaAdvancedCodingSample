package com.ImmutablityAndNullObjects;

public class Player implements Cloneable {
    private int id;
    private String name;
    public Player(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void main(String args[]) throws CloneNotSupportedException {
        Player p1 = new Player(1, "Rafael Nadal");
        Player p2 = new Player(1, "Rafael Nadal");
        Player p3= (Player) p1.clone();
        System.out.println("p1 hash code: " + p1.hashCode()); // 1809787067
        System.out.println("p2 hash code: " + p2.hashCode()); // 157627094
        System.out.println("p3 hash code: " + p3.hashCode()); // 157627094

    }

}
