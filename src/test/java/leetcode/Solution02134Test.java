package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02134Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minSwaps(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution02134().minSwaps(nums));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[0,1,0,1,1,0,0]", 1),
                Arguments.of("[0,1,1,1,0,0,1,1,0]", 2),
                Arguments.of("[1,1,1]", 0),
                Arguments.of("[1,0,0,1]", 0)
        );
    }

}