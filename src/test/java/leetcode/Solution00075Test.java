package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00075Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sortColors(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[] expected = ArrayUtils.stringToIntArray(expectedStr);
        new Solution00075().sortColors(nums);
        assertArrayEquals(expected, nums);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,0,2,1,1,0]", "[0,0,1,1,2,2]"),
                Arguments.of("[2,0,1]", "[0,1,2]"),
                Arguments.of("[0]", "[0]"),
                Arguments.of("[1]", "[1]")
        );
    }

}