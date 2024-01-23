package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00189Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7}, 3, new int[]{5, 6, 7, 1, 2, 3, 4}),
                Arguments.of(new int[]{-1, -100, 3, 99}, 2, new int[]{3, 99, -1, -100})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rotateBruteforce(int[] nums, int k, int[] expected) {
        Solution00189 solution = new Solution00189();
        solution.rotateBruteforce(nums, k);
        assertArrayEquals(expected, nums);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rotateCyclicReplacement(int[] nums, int k, int[] expected) {
        Solution00189 solution = new Solution00189();
        solution.rotateCyclicReplacement(nums, k);
        assertArrayEquals(expected, nums);
    }

}
