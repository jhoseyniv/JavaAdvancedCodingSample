package com.testunit;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class TestHighOrderFunction {

    @FunctionalInterface
    public interface Replacer<String> {
        String replace(String s);
    }

    public static List<String> replace(List<String> list, Replacer<String> r) {
        List<String> result = new ArrayList<>();
        for (String s: list) {
            result.add(r.replace(s));
        }
        return result;
    }

    public static final Function<String, String> firstAndLastChar
            = (String s) -> String.valueOf(s.charAt(0))
            + String.valueOf(s.charAt(s.length() - 1));

    @Test
    public void testReplacer() throws Exception {
        List<String> names = Arrays.asList("Ann a 15", "Mir el 28", "D oru 33");
        List<String> resultWs = replace(names, (String s) -> s.replaceAll("\\s", ""));
        List<String> resultNr = replace( names, (String s) -> s.replaceAll("\\d", ""));
        assertEquals(Arrays.asList( "Anna15", "Mirel28", "Doru33"), resultWs);
        assertEquals(Arrays.asList( "Ann a ", "Mir el ", "D oru "), resultNr);
    }

    @Test
    public void testFirstAndLastChar() throws Exception {
        String text = "Lambda";
        String result = firstAndLastChar.apply(text);
        assertEquals("La", result);
    }

}
