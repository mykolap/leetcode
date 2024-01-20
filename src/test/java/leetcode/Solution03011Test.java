package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03011Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3, 4, 5}, true),
                Arguments.of(new int[]{3, 16, 8, 4, 2}, false),
                Arguments.of(new int[]{10, 3, 1, 1}, false),
                Arguments.of(new int[]{1, 2, 4, 8, 16}, true)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canSortArray(int[] nums, boolean expected) {
        boolean actual = new Solution03011().canSortArray(nums);
        assertEquals(expected, actual);
    }

}