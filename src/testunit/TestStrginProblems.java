package testunit;

import com.company.StringUtilites;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestStrginProblems {
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

    @TestFactory
    Collection<DynamicTest> test_CheckAllChractoerAreDigits(){
        return Arrays.asList(
                dynamicTest("first test",
                        ()-> assertTrue( StringUtilites.checkAStringcontainOnlyDigit_ByJava8("877565623423409888"))),
                dynamicTest("2th test",
                        ()-> assertTrue( StringUtilites.checkAStringcontainOnlyDigit_ByJava8("877565623423409888"))),
                dynamicTest("3th test",
                        ()-> assertTrue( StringUtilites.checkAStringcontainOnlyDigit_ByJava8("8775656 23423409888")))
        );
    }
    @TestFactory
    Collection<DynamicTest> test_CheckCountVowelAndConsonant(){
        return Arrays.asList(
                dynamicTest("first test",
                        ()-> assertEquals("5=2",StringUtilites.countVowelsAndConsonants("abcuioe").toString())),

                dynamicTest("2th test",
                        ()-> assertEquals("0=20",StringUtilites.countVowelsAndConsonants("bclkmng$%%^&*(tprwdqzxcvJLKB").toString())),

                dynamicTest("3th test",
                ()-> assertEquals("5=0",StringUtilites.countVowelsAndConsonants("aioue").toString())),

                dynamicTest("4th test",
                        ()-> assertEquals("0=0",StringUtilites.countVowelsAndConsonants("").toString()))
                );
    }
    @TestFactory
    Collection<DynamicTest> test_CheckCountSpecialCharacter(){
        return Arrays.asList(
                dynamicTest("first test" ,
                        ()->assertEquals(new Long(1),StringUtilites.countOccurrencesOfACertainCharacter("abcaaggiiia",'c'))  ),
                dynamicTest("2th test" ,
                        ()->assertEquals(new Long(4),StringUtilites.countOccurrencesOfACertainCharacter("abcaaggiiia",'a'))  )
        );
    }
}
