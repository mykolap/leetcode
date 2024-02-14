package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00207Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(2, new int[][]{{1, 0}}, true),
                Arguments.of(2, new int[][]{{1, 0}, {0, 1}}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void canFinish(int numCourses, int[][] prerequisites, boolean expected) {
        boolean actual = new Solution00207().canFinish(numCourses, prerequisites);
        assertEquals(expected, actual);
    }

}