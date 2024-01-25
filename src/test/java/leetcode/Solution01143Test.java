package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01143Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcde", "ace", 3),
                Arguments.of("abc", "abc", 3),
                Arguments.of("abc", "def", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void pseudoPalindromicPaths(String text1, String text2, int expected) {
        int actual = new Solution01143().longestCommonSubsequence(text1, text2);
        assertEquals(expected, actual);
    }

}