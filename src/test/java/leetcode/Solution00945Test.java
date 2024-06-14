package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00945Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minIncrementForUnique(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution00945().minIncrementForUnique(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,2]", 1),
                Arguments.of("[3,2,1,2,1,7]", 6)
        );
    }

}