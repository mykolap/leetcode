package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00134Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canCompleteCircuit(int[] gas, int[] cost, int expected) {
        int result = new Solution00134().canCompleteCircuit(gas, cost);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return java.util.stream.Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}, 3),
                Arguments.of(new int[]{2, 3, 4}, new int[]{3, 4, 3}, -1)
        );
    }

}