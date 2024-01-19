package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00027Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 2, 3}, 3,
                        2, new int[]{2, 2}),
                Arguments.of(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2,
                        5, new int[]{0, 1, 3, 0, 4})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeElement(int[] nums, int val,
                       int expected, int[] expectedNums) {
        int actual = new Solution00027().removeElement(nums, val);
        assertEquals(expected, actual);
        for (int i = 0; i < actual; i++) {
            assertEquals(expectedNums[i], nums[i]);
        }
    }

}