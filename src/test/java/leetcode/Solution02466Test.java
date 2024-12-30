package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02466Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countGoodStrings(int low, int high, int zero, int one, int expected) {
        final int actual = new Solution02466().countGoodStrings(low, high, zero, one);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 3, 1, 1, 8),
                Arguments.of(2, 3, 1, 2, 5)
        );
    }

}