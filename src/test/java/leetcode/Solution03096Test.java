package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03096Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumLevels(int[] nums, int expected) {
        int result = new Solution03096().minimumLevels(nums);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 0, 1, 0}, 1),
                Arguments.of(
                        new int[]{1, 1, 1, 1, 1}, 3),
                Arguments.of(
                        new int[]{0, 0}, -1),
                Arguments.of(
                        new int[]{1, 1}, -1)
        );
    }

}