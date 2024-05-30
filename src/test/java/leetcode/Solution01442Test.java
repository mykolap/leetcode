package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01442Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countTriplets(String arrStr, int expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        int actual = new Solution01442().countTriplets(arr);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countTripletsOptimized(String arrStr, int expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        int actual = new Solution01442().countTripletsOptimized(arr);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,3,1,6,7]", 4),
                Arguments.of("[1,1,1,1,1]", 10),
                Arguments.of("[2,3]", 0),
                Arguments.of("[1,3,5,7,9]", 3),
                Arguments.of("[7,11,12,9,5,2,7,17,22]", 8)
        );
    }

}