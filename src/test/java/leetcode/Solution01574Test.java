package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01574Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findLengthOfShortestSubarray(String arrStr, int expected) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        assertEquals(expected, new Solution01574().findLengthOfShortestSubarray(arr));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,10,4,2,3,5]", 3),
                Arguments.of("[5,4,3,2,1]", 4),
                Arguments.of("[1,2,3]", 0)
        );
    }

}