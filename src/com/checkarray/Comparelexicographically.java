package com.checkarray;

import com.sort.Melon;
import org.apache.commons.math3.util.MathArrays;

import java.util.Arrays;

public class Comparelexicographically {

    public static void main(String args[]){
        int[] integers1 = {3, 4, 5, 6, 1, 5};
        int[] integers2 = {3, 4, 5, 6, 1, 5};
        int[] integers3 = {3, 4, 5, 6, 1, 3};

        int i12 = Arrays.compare(integers1, integers2); // 0
        int i13 = Arrays.compare(integers1, integers3); // 1

        Melon[] melons1 = {new Melon("Horned", 1500), new Melon("Gac", 1000)};
        Melon[] melons2 = {new Melon("Horned", 1500), new Melon("Gac", 1000)};
        Melon[] melons3 = {new Melon("Hami", 1600), new Melon("Gac", 800)};


        int m12 = Arrays.compare(melons1, melons2); // 0
        int m13 = Arrays.compare(melons1, melons3); // -1

        double avg = Arrays.stream(integers1).average().getAsDouble();
        int max = Arrays.stream(integers1).max().getAsInt();
        System.out.println("max  is  = " +  max +" and avg is " + avg);
    }
}
