package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02762Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void continuousSubarrays(String numsStr, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        long actual = new Solution02762().continuousSubarrays(nums);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,4,2,4]", 8),
                Arguments.of("[1,2,3]", 6)
        );
    }

}