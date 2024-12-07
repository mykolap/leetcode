package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01760Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumSize(String numsStr, int maxOperations, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = new Solution01760().minimumSize(nums, maxOperations);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[9]", 2, 3),
                Arguments.of("[2,4,8,2]", 4, 2)
        );
    }

}