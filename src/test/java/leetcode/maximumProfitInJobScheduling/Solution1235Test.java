package leetcode.maximumProfitInJobScheduling;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1235Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 3}, new int[]{3, 4, 5, 6}, new int[]{50, 10, 40, 70}, 120),
                Arguments.of(new int[]{1, 2, 3, 4, 6}, new int[]{3, 5, 10, 6, 9}, new int[]{20, 20, 100, 70, 60}, 150),
                Arguments.of(new int[]{1, 1, 1}, new int[]{2, 3, 4}, new int[]{5, 6, 4}, 6)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void jobScheduling(int[] startTime, int[] endTime, int[] profit, int expected) {
        assertEquals(expected, new Solution1235().jobScheduling(startTime, endTime, profit));
    }

}