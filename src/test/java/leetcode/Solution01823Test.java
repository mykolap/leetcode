package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01823Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findTheWinner(int n, int k, int expected) {
        int result = new Solution01823().findTheWinner(n, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findTheWinnerRecursively(int n, int k, int expected) {
        int result = new Solution01823().findTheWinnerRecursively(n, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, 2, 3),
                Arguments.of(6, 5, 1),
                Arguments.of(10, 17, 3)
        );
    }

}