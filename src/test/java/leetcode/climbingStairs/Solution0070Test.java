package leetcode.climbingStairs;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0070Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, 2),
                Arguments.of(3, 3),
                Arguments.of(4, 5),
                Arguments.of(5, 8),
                Arguments.of(6, 13),
                Arguments.of(7, 21),
                Arguments.of(8, 34),
                Arguments.of(9, 55),
                Arguments.of(10, 89),
                Arguments.of(11, 144),
                Arguments.of(12, 233),
                Arguments.of(13, 377),
                Arguments.of(14, 610),
                Arguments.of(15, 987),
                Arguments.of(16, 1597),
                Arguments.of(17, 2584),
                Arguments.of(18, 4181),
                Arguments.of(19, 6765),
                Arguments.of(20, 10946),
                Arguments.of(21, 17711),
                Arguments.of(22, 28657),
                Arguments.of(23, 46368),
                Arguments.of(24, 75025)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void climbStairs(int n, int expected) {
        assertEquals(expected, new Solution0070().climbStairs(n));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void climbStairsFirstApproach(int n, int expected) {
        assertEquals(expected, new Solution0070().climbStairsFirstApproach(n));
    }

}