package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00974Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subarraysDivByK(String numsStr, int k, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        var solution = new Solution00974();
        var result = solution.subarraysDivByK(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,5,0,-2,-3,1]", 5, 7),
                Arguments.of("[5]", 9, 0),
                Arguments.of("[-1,2,9]", 2, 2)
        );
    }

}