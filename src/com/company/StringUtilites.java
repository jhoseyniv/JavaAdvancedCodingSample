package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class StringUtilites {


    public static Character getFirstNonRepeatCharacter(String input) {
        final int ASCII_CODE_NUMBER=256;
        Character character = null;
        int[] result = new int[ASCII_CODE_NUMBER];

        for( int i=0 ; i<result.length ; i++ ){
            result[i] = -1;
        }

        for(int i = 0; i<input.length(); i++){
            Character ch = input.charAt(i);
            result[ch.charValue()] ++ ;
        }

        for(int i = 0; i<result.length; i++){
            if(result[i] == 0) return (char)i;
        }
        return  character;
    }

    public static Map<String, Integer> getDuplicateWordsWithCounts(String input){
        Map<String , Integer> wordsAndCounts= new HashMap<>();
        String[] words = input.split(" ");
        for(String word :words){
            wordsAndCounts.compute(word,(k,v) -> (v == null) ? 1 : ++v);
        }
        return  wordsAndCounts;
    }

    public static boolean checkAStringcontainOnlyDigit_Sol1(String input){
        return  input.matches("[0-9]+");
    }

    public static boolean checkAStringcontainOnlyDigit_ByJava8(String input) {
        return  input.chars().allMatch(n -> Character.isDigit(n));
    }
}
