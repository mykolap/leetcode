package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01930Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countPalindromicSubsequence(String s, int expected) {
        int actual = new Solution01930().countPalindromicSubsequence(s);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("aabca", 3),
                Arguments.of("adc", 0),
                Arguments.of("bbcbaba", 4)
        );
    }

}