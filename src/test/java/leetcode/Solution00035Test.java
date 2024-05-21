package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00035Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void searchInsert(String numsStr, int target, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution00035().searchInsert(nums, target));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,3,5,6]", 5, 2),
                Arguments.of("[1,3,5,6]", 2, 1),
                Arguments.of("[1,3,5,6]", 7, 4),
                Arguments.of("[1,3,5,6]", 0, 0)
        );
    }

}