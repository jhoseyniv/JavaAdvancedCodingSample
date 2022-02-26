package com.checkarray;

import com.sort.Melon;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysEquality {

    public static void main(String args[]){
        int[] integers1 = {3, 4, 5, 6, 1, 5};
        int[] integers2 = {3, 4, 5, 6, 1, 5};
        int[] integers3 = {3, 4, 5, 6, 1, 3};
        boolean i12 = Arrays.equals(integers1, integers2); // true
        boolean i13 = Arrays.equals(integers1, integers3); // false


        Melon[] melons1 = {
                new Melon("Horned", 1500), new Melon("Gac", 1000)
            };

        Melon[] melons2 = {
                new Melon("Horned", 1500), new Melon("Gac", 1000)
        };
        Melon[] melons3 = {
                new Melon("Hami", 1500), new Melon("Gac", 1000)
        };
        boolean m12 = Arrays.equals(melons1, melons2); // true
        boolean m13 = Arrays.equals(melons1, melons3); // false


        Comparator<Melon> byType = Comparator.comparing(Melon::getType);
        Comparator<Melon> byWeight = Comparator.comparing(Melon::getWeight);

        boolean mw13 = Arrays.equals(melons1, melons3, byWeight); // true
        boolean mt13 = Arrays.equals(melons1, melons3, byType); // false


        int mi12 = Arrays.mismatch(integers1, integers2); // -1 mean that integers1 and integers2 are equal

        int mm13 = Arrays.mismatch(melons1, melons3); // 0  mean that melon1 and melon3 are not equal

    }
}
