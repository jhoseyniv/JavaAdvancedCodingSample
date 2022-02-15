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

    }

   @TestFactory
	Collection<DynamicTest> test_GetFirstNonRepeatCharacter(){
		return Arrays.asList(
				dynamicTest("first test ",
						()->assertEquals( new Character('d'),
								StringUtilites.getFirstNonRepeatCharacter("salamQsaeeQdjanaliiehow"))),

				dynamicTest("2th test ",
						()->assertEquals( new Character('Q'),
								StringUtilites.getFirstNonRepeatCharacter("salamQsaeedjanaliiehow"))),

				dynamicTest("3th test ",
						()->assertEquals( null,
								StringUtilites.getFirstNonRepeatCharacter(""))),

				dynamicTest("4th test ",
						()->assertEquals( new Character(' '),
								StringUtilites.getFirstNonRepeatCharacter(" sdfkjhksjdfkjfdsfhjgweiurdsfjfhjdsf")))
		);

   }

}
