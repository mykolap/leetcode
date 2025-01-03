package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02270Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void waysToSplitArray(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution02270().waysToSplitArray(nums);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[10,4,-8,7]", 2),
                Arguments.of("[2,3,1,0]", 2)
        );
    }

}