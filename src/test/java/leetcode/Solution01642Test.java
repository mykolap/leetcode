package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01642Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1, 4),
                Arguments.of(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2, 7),
                Arguments.of(new int[]{14, 3, 19, 3}, 17, 0, 3)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void furthestBuilding(int[] heights, int bricks, int ladders, int expected) {
        assertEquals(expected, new Solution01642().furthestBuilding(heights, bricks, ladders));
    }

}