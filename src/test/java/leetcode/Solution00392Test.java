package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00392Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isSubsequence(String s, String t, boolean expected) {
        Solution00392 solution = new Solution00392();
        boolean output = solution.isSubsequence(s, t);
        assertEquals(expected, output);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abc", "ahbgdc", true),
                Arguments.of("axc", "ahbgdc", false),
                Arguments.of("acb", "ahbgdc", false)
        );
    }
}