package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02373Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void largestLocal(String gridStr, String expectedStr) {
        int[][] grid = ArrayUtils.stringTo2DIntArray(gridStr);
        int[][] result = new Solution02373().largestLocal(grid);
        assertThat(ArrayUtils.int2DArrayToString(result)).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]",
                        "[[9,9],[8,6]]"),
                Arguments.of("[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]",
                        "[[2,2,2],[2,2,2],[2,2,2]]")
        );
    }

}