package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02044Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countMaxOrSubsets(String numsStr, int expected) {
        Solution02044 solution02044 = new Solution02044();
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int actual = solution02044.countMaxOrSubsets(nums);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,1]", 2),
                Arguments.of("[2,2,2]", 7),
                Arguments.of("[3,2,1,5]", 6)
        );
    }

}