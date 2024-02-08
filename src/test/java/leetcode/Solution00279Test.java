package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00279Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(12, 3),
                Arguments.of(13, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numSquaresDP(int n, int expected) {
        assertEquals(expected, new Solution00279().numSquaresDP(n));
    }

}