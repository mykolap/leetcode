package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03039Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lastNonEmptyString(String s, String expected) {
        String actual = new Solution03039().lastNonEmptyString(s);
        assertEquals(expected, actual);
    }

    static String[][] casesProvider() {
        return new String[][]{
                {"aabcbbca", "ba"},
                {"abcd", "abcd"}
        };
    }

}