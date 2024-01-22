package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00169Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{3, 2, 3}, 3),
                Arguments.of(new int[]{2, 2, 1, 1, 1, 2, 2}, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void majorityElement(int[] nums, int expected) {
        Solution00169 solution = new Solution00169();
        int actual = solution.majorityElement(nums);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void majorityElementMap(int[] nums, int expected) {
        Solution00169 solution = new Solution00169();
        int actual = solution.majorityElementMap(nums);
        assertEquals(expected, actual);
    }

}