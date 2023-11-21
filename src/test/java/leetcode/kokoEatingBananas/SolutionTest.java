package leetcode.kokoEatingBananas;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getMinEatingSpeedArgs() {
        return Stream.of(
                Arguments.of(new int[]{3, 6, 7, 11}, 8, 4),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 5, 30),
                Arguments.of(new int[]{30, 11, 23, 4, 20}, 6, 23),
                Arguments.of(new int[]{312884470}, 968709470, 1),
                Arguments.of(new int[]{805306368, 805306368, 805306368}, 1000000000, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("getMinEatingSpeedArgs")
    void minEatingSpeed(int[] piles, int h, int expected) {
        assertEquals(expected, new Solution().minEatingSpeed(piles, h));
    }

}