package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00796Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rotateString(String s, String goal, boolean expected) {
        Solution00796 solution = new Solution00796();
        assertEquals(expected, solution.rotateString(s, goal));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcde", "cdeab", true),
                Arguments.of("abcde", "abced", false)
        );
    }

}