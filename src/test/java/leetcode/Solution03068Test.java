package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03068Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumValueSum(String numStr, int k, String edgesStr, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numStr);
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        assertEquals(expected, new Solution03068().maximumValueSum(nums, k, edges));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumValueSumOptimized(String numStr, int k, String edgesStr, long expected) {
        int[] nums = ArrayUtils.stringToIntArray(numStr);
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        assertEquals(expected, new Solution03068().maximumValueSumOptimized(nums, k, edges));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,1]", 3, "[[0,1],[0,2]]", 6),
                Arguments.of("[2,3]", 7, "[[0,1]]", 9),
                Arguments.of("[7,7,7,7,7,7]", 3, "[[0,1],[0,2],[0,3],[0,4],[0,5]]", 42),
                Arguments.of("[7,7,7,7,7,7]", 1000000000, "[[0,1],[0,2],[0,3],[0,4],[0,5]]", 6000000042L)
        );
    }

}