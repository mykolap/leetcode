package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01593Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxUniqueSplit(String input, int expected) {
        Solution01593 solution01593 = new Solution01593();
        assertEquals(expected, solution01593.maxUniqueSplit(input));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("ababccc", 5),
                Arguments.of("aba", 2),
                Arguments.of("aa", 1)
        );
    }

}