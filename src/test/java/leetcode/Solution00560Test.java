package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00560Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subarraySum(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        var solution = new Solution00560();
        var result = solution.subarraySum(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,1,1]", 2, 2),
                Arguments.of("[1,2,3]", 3, 2)
        );
    }

}