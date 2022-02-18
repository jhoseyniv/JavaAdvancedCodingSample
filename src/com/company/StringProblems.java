package com.company;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.platform.commons.util.StringUtils;
import  static org.junit.jupiter.api.DynamicTest.dynamicTest;
import  static  org.junit.Assert.*;
public class StringProblems {

    public static void main(String[] args) {
		String input = " ali reza ali reza ali ali ali kk l kk lol lol saeed reza";
	    Map<String,Integer> result = StringUtilites.getDuplicateWordsWithCounts(input);
	    result.entrySet().forEach(System.out::println);
		StringUtilites.countVowelsAndConsonants(input);
    }



}
