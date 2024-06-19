package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01482Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minDays(String bloomDayStr, int m, int k, int expected) {
        int[] bloomDay = ArrayUtils.stringToIntArray(bloomDayStr);
        int result = new Solution01482().minDays(bloomDay, m, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,10,3,10,2]", 3, 1, 3),
                Arguments.of("[1,10,3,10,2]", 3, 2, -1),
                Arguments.of("[7,7,7,7,12,7,7]", 2, 3, 12),
                Arguments.of("[1000000000,1000000000]", 1, 1, 1000000000),
                Arguments.of("[1,10,2,9,3,8,4,7,5,6]", 4, 2, 9)
        );
    }

}