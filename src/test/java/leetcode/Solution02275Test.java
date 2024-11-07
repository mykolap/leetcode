package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02275Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void largestCombination(String candidatesStr, int expected) {
        int[] candidates = ArrayUtils.stringToIntArray(candidatesStr);
        int actual = new Solution02275().largestCombination(candidates);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[16,17,71,62,12,24,14]", 4),
                Arguments.of("[8,8]", 2)
        );
    }
}