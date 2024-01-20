package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00026Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 2}, 2, new int[]{1, 2}),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
                        5, new int[]{0, 1, 2, 3, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeDuplicates(int[] nums, int expected, int[] expectedNums) {
        final int actual = new Solution00026().removeDuplicates(nums);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

}