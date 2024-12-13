package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02593Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findScore(String numsStr, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        long actual = new Solution02593().findScore(nums);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,1,3,4,5,2]", 7L),
                Arguments.of("[2,3,5,1,3,2]", 5L)
        );
    }

}