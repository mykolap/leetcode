package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01957Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void makeFancyString(String input, String expected) {
        Solution01957 solution = new Solution01957();
        assertEquals(expected, solution.makeFancyString(input));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("leeetcode", "leetcode"),
                Arguments.of("aaabaaa", "aabaa"),
                Arguments.of("aab", "aab")
        );
    }

}