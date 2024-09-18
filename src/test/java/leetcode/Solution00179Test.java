package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00179Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void largestNumber(String numsStr, String expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        assertEquals(expected, new Solution00179().largestNumber(nums));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[10,2]", "210"),
                Arguments.of("[3,30,34,5,9]", "9534330"),
                Arguments.of("[0, 0, 0]", "0")
        );
    }

}