package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00633Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void judgeSquareSum(int c, boolean expected) {
        boolean result = new Solution00633().judgeSquareSum(c);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void judgeSquareSumOptimized(int c, boolean expected) {
        boolean result = new Solution00633().judgeSquareSumOptimized(c);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, true),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(2, true),
                Arguments.of(1, true),
                Arguments.of(0, true),
                Arguments.of(1000000000, true),
                Arguments.of(2147483600, true)
        );
    }

}