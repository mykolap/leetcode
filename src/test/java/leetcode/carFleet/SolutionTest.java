package leetcode.carFleet;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    static Stream<Arguments> getCarFleetArgs() {
        return Stream.of(
                Arguments.of(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}, 3),
                Arguments.of(10, new int[]{3}, new int[]{3}, 1),
                Arguments.of(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("getCarFleetArgs")
    void carFleet(int target, int[] position, int[] speed, int expected) {
        assertEquals(expected, new Solution().carFleet(target, position, speed));
    }

}