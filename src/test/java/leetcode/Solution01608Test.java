package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01608Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void specialArray(String numsStr, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int result = new Solution01608().specialArray(nums);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,5]", 2),
                Arguments.of("[0,1]", 1),
                Arguments.of("[0,0]", -1),
                Arguments.of("[0,4,3,0,4]", 3),
                Arguments.of("[3,6,7,7,0]", -1),
                Arguments.of("[0]", -1)
        );
    }

}