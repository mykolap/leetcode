package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01347Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                // Example 1.
                Arguments.of("bab", "aba", 1),
                // Example 2.
                Arguments.of("leetcode", "practice", 5),
                // Example 3.
                Arguments.of("anagram", "mangaar", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minSteps(String s, String t, int expected) {
        int actual = new Solution01347().minSteps(s, t);
        assertEquals(expected, actual);
    }

}