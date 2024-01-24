package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00121Test {

    static Stream<Arguments> getMaxProfitArgs() {
        return Stream.of(
                Arguments.of(new int[]{7, 1, 5, 3, 6, 4}, 5),
                Arguments.of(new int[]{7, 6, 4, 3, 1}, 0),
                Arguments.of(new int[]{2, 4, 1}, 2),
                Arguments.of(new int[]{2, 1, 2, 1, 0, 1, 2}, 2),
                Arguments.of(new int[]{5}, 0),
                Arguments.of(new int[]{2, 5}, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getMaxProfitArgs")
    void maxProfit(int[] prices, int expected) {
        int actual = new Solution00121().maxProfit(prices);
        assertEquals(expected, actual);
    }

}