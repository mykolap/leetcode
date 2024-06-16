package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00330Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minPatches(String numsStr, int n, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution00330().minPatches(nums, n);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3]", 6, 1),
                Arguments.of("[1,5,10]", 20, 2),
                Arguments.of("[1,2,2]", 5, 0),
                Arguments.of("[1,2,31,33]", 2147483647, 28),
                Arguments.of("[3]", 2, 2),
                Arguments.of("[1,5]", 7, 2)
        );
    }

}