package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00080Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 2, 2, 3}, 5, new int[]{1, 1, 2, 2, 3, 3}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}, 7, new int[]{0, 0, 1, 1, 2, 3, 3, 3, 3})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeDuplicates(int[] nums, int expected, int[] expectedNums) {
        assertEquals(expected, new Solution00080().removeDuplicates(nums));
        for (int i = 0; i < expected; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

}