package com.stringproblems;

import java.util.Map;

import  static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class StringProblems {

    public static void main(String[] args) {
		String input = " ali reza ali reza ali ali ali kk l kk lol lol saeed reza";
	    Map<String,Integer> result = StringUtilites.getDuplicateWordsWithCounts(input);
	    result.entrySet().forEach(System.out::println);
		StringUtilites.countVowelsAndConsonants(input);
    }



}
