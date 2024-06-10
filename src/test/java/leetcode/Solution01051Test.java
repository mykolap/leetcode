package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01051Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void heightChecker(String heightsStr, int expected) {
        int[] heights = ArrayUtils.stringToIntArray(heightsStr);
        int result = new Solution01051().heightChecker(heights);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void heightCheckerCountingSort(String heightsStr, int expected) {
        int[] heights = ArrayUtils.stringToIntArray(heightsStr);
        int result = new Solution01051().heightCheckerCountingSort(heights);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,1,4,2,1,3]", 3),
                Arguments.of("[5,1,2,3,4]", 5),
                Arguments.of("[1,2,3,4,5]", 0)
        );
    }

}