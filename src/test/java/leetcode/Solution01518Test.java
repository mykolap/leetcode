package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01518Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numWaterBottles(int numBottles, int numExchange, int expected) {
        int result = new Solution01518().numWaterBottles(numBottles, numExchange);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(9, 3, 13),
                Arguments.of(15, 4, 19),
                Arguments.of(5, 5, 6),
                Arguments.of(2, 3, 2)
        );
    }

}