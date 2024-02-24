package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00567Test {

    static Stream<Arguments> getCheckInclusionArgs() {
        return Stream.of(
                Arguments.of("ab", "eidbaooo", true),
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("adc", "dcda", true),
                Arguments.of("hello", "ooolleoooleh", false),
                Arguments.of("hello", "hello", true),
                Arguments.of("helllo", "helllo", true),
                Arguments.of("hello", "ll", false),
                Arguments.of("abc", "bbbca", true)
        );
    }

    @ParameterizedTest
    @MethodSource("getCheckInclusionArgs")
    void checkInclusion(String s1, String s2, boolean expected) {
        boolean actual = new Solution00567().checkInclusion(s1, s2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getCheckInclusionArgs")
    void checkInclusionArrayEquals(String s1, String s2, boolean expected) {
        boolean actual = new Solution00567().checkInclusionArrayEquals(s1, s2);
        assertEquals(expected, actual);
    }
}