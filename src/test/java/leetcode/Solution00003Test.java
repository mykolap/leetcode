package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00003Test {

    static Stream<Arguments> getLengthOfLongestSubstringArgs() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("", 0),
                Arguments.of("dvdf", 3),
                Arguments.of("abba", 2),
                Arguments.of("tmmzuxt", 5),
                Arguments.of("ohvhjdml", 6),
                Arguments.of("abcabcbb", 3),
                Arguments.of("abcb", 3),
                Arguments.of("bbtablud", 6),
                Arguments.of("ckilbkd", 5),
                Arguments.of("aab", 2)
        );
    }

    @ParameterizedTest
    @MethodSource("getLengthOfLongestSubstringArgs")
    void lengthOfLongestSubstring(String s, int expected) {
        int actual = new Solution00003().lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getLengthOfLongestSubstringArgs")
    void lengthOfLongestSubstringIntArr(String s, int expected) {
        int actual = new Solution00003().lengthOfLongestSubstringIntArr(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("getLengthOfLongestSubstringArgs")
    void lengthOfLongestSubstringMap(String s, int expected) {
        int actual = new Solution00003().lengthOfLongestSubstringMap(s);
        assertEquals(expected, actual);
    }

}