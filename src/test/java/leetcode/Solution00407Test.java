package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00407Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void trapRainWater(String heightMapStr, int expected) {
        int[][] heightMap = ArrayUtils.stringToInt2DArray(heightMapStr);
        int result = new Solution00407().trapRainWater(heightMap);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,4,3,1,3,2],[3,2,1,3,2,4],[2,3,3,2,3,1]]", 4),
                Arguments.of("[[3,3,3,3,3],[3,2,2,2,3],[3,2,1,2,3],[3,2,2,2,3],[3,3,3,3,3]]", 10)
        );
    }

}