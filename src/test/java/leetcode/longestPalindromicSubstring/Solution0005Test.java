package leetcode.longestPalindromicSubstring;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0005Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("babad", "bab"),
                Arguments.of("cbbd", "bb"),
                Arguments.of("a", "a"),
                Arguments.of("ac", "a"),
                Arguments.of("bb", "bb"),
                Arguments.of("ccc", "ccc"),
                Arguments.of("aaaa", "aaaa")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestPalindromeBruteforce(String s, String expected) {
        String actual = new Solution0005().longestPalindromeBruteforce(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestPalindromeExpandAroundCenter(String s, String expected) {
        String actual = new Solution0005().longestPalindromeExpandAroundCenter(s);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestPalindromeDynamicProgramming(String s, String expected) {
        String actual = new Solution0005().longestPalindromeDynamicProgramming(s);
        assertEquals(expected, actual);
    }

}