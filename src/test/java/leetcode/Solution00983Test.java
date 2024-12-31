package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00983Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mincostTickets(String daysStr, String costsStr, int expected) {
        int[] days = ArrayUtils.stringToIntArray(daysStr);
        int[] costs = ArrayUtils.stringToIntArray(costsStr);
        int result = new Solution00983().mincostTickets(days, costs);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,4,6,7,8,20]", "[2,7,15]", 11),
                Arguments.of("[1,2,3,4,5,6,7,8,9,10,30,31]", "[2,7,15]", 17)
        );
    }

}