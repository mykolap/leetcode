package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution02149Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{3, 1, -2, -5, 2, -4},
                        new int[]{3, -2, 1, -5, 2, -4}
                ),
                Arguments.of(
                        new int[]{-1, 1},
                        new int[]{1, -1}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rearrangeArray(int[] nums, int[] expected) {
        int[] actual = new Solution02149().rearrangeArray(nums);
        assertArrayEquals(expected, actual);
    }

}