package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03024Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{1, 2, 3}, "none"),
                Arguments.of(new int[]{2, 3, 9}, "none"),
                Arguments.of(new int[]{2, 2, 2}, "equilateral"),
                Arguments.of(new int[]{3, 4, 5}, "scalene"),
                Arguments.of(new int[]{3, 4, 4}, "isosceles"),
                Arguments.of(new int[]{3, 3, 4}, "isosceles"),
                Arguments.of(new int[]{3, 4, 6}, "scalene")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void triangleType(int[] nums, String expected) {
        assertEquals(expected, new Solution03024().triangleType(nums));
    }
}