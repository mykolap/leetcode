package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00214Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void shortestPalindrome(String s, String expected) {
        String result = new Solution00214().shortestPalindrome(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aacecaaa", "aaacecaaa"),
                Arguments.of("abcd", "dcbabcd"),
                Arguments.of("a", "a"),
                Arguments.of("", "")
        );
    }

}