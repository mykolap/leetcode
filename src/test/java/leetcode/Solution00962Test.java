package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00962Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxWidthRamp(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution00962().maxWidthRamp(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[6,0,8,2,1,5]", 4),
                Arguments.of("[9,8,1,0,1,9,4,0,4,1]", 7)
        );
    }

}