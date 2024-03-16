package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00525Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMaxLength(int[] nums, int expected) {
        int result = new Solution00525().findMaxLength(nums);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findMaxLengthMap(int[] nums, int expected) {
        int result = new Solution00525().findMaxLengthMap(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{0, 1}, 2),
                Arguments.of(new int[]{0, 1, 0}, 2),
                Arguments.of(new int[]{1, 1, 1, 0, 0}, 4)
        );
    }
}