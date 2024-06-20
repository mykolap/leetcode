package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01552Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxDistance(String positionStr, int m, int expected) {
        int[] position = ArrayUtils.stringToIntArray(positionStr);
        int result = new Solution01552().maxDistance(position, m);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4,7]", 3, 3),
                Arguments.of("[5,4,3,2,1,1000000000]", 2, 999999999),
                Arguments.of("[79,74,57,22]", 4, 5)
        );
    }

}