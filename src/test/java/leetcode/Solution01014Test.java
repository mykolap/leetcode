package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01014Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxScoreSightseeingPair(String valuesStr, int expected) {
        int[] values = ArrayUtils.stringToIntArray(valuesStr);
        int actual = new Solution01014().maxScoreSightseeingPair(values);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxScoreSightseeingPairDp(String valuesStr, int expected) {
        int[] values = ArrayUtils.stringToIntArray(valuesStr);
        int actual = new Solution01014().maxScoreSightseeingPairDp(values);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[8,1,5,2,6]", 11),
                Arguments.of("[1,2]", 2)
        );
    }

}