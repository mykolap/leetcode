package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00992Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subarraysWithKDistinctViaAtMost(int[] nums, int k, int expected) {
        int result = new Solution00992().subarraysWithKDistinctViaAtMost(nums, k);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void subarraysWithKDistinctVia3Pointers(int[] nums, int k, int expected) {
        int result = new Solution00992().subarraysWithKDistinctVia3Pointers(nums, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 1, 2, 3},
                        2, 7),
                Arguments.of(new int[]{1, 2, 1, 3, 4},
                        3, 3),
                Arguments.of(new int[]{2, 2, 1, 2, 2, 2, 1, 1},
                        2, 23)
        );
    }

}