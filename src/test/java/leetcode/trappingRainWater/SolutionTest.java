package leetcode.trappingRainWater;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getTrappingRainWaterArgs() {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}, 6),
                Arguments.of(new int[]{4, 2, 0, 3, 2, 5}, 9)
        );
    }

    @ParameterizedTest
    @MethodSource("getTrappingRainWaterArgs")
    void trap(int[] height, int expected) {
        assertEquals(expected, new Solution().trap(height));
    }

    @ParameterizedTest
    @MethodSource("getTrappingRainWaterArgs")
    void trapBruteForce(int[] height, int expected) {
        assertEquals(expected, new Solution().trapBruteForce(height));
    }

}