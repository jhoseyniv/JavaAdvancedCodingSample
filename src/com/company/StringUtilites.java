package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javafx.util.Pair;

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
    public static Pair<Integer, Integer> countVowelsAndConsonants(String str) {
        ArrayList<Character> vowelCharachters= new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        char firstChar = 'a';
        char encChar = 'z';
        int vowelCount = 0;
        int consonanetCount = 0;
        String strLoweCase = str.toLowerCase();

        for(int i=0; i < strLoweCase.length(); i++){
            char character = strLoweCase.charAt(i);
            if(vowelCharachters.contains(character)) {
                vowelCount++;
            }
            else if( character > firstChar  && character < encChar ){
                consonanetCount++;
            }
        }
       return new Pair<Integer, Integer>(vowelCount, consonanetCount);
    }
    public static Pair<Long, Long> countVowelsAndConsonantsByJava8(String str) {
        ArrayList<Character> vowelCharachters= new ArrayList<>(Arrays.asList('a','e','i','o','u'));
        long vowelCount = 0;
        long consonanetCount = 0;
        String strLoweCase = str.toLowerCase();

        vowelCount = strLoweCase.chars().filter(c -> vowelCharachters.contains((char)c)).count();
        consonanetCount = strLoweCase.chars().filter( c -> !vowelCharachters.contains((char) c)).
                            filter(ch -> (ch >'a' && ch <'z' )).count();

        return new Pair<Long, Long>(vowelCount, consonanetCount);

    }
}
