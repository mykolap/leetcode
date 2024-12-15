package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01792Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxAverageRatio(String classesStr, int extraStudents, double expected) {
        int[][] classes = ArrayUtils.stringToInt2DArray(classesStr);
        double actual = new Solution01792().maxAverageRatio(classes, extraStudents);
        assertEquals(expected, actual, 1e-5);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2],[3,5],[2,2]]", 2, 0.78333),
                Arguments.of("[[2,4],[3,9],[4,5],[2,10]]", 4, 0.53485)
        );
    }

}