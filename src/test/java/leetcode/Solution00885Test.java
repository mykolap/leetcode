package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00885Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void spiralMatrixIII(int rows, int cols, int rStart, int cStart, String expectedStr) {
        int[][] actual = new Solution00885().spiralMatrixIII(rows, cols, rStart, cStart);
        assertThat(Arrays.deepToString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(1, 4, 0, 0, "[[0,0],[0,1],[0,2],[0,3]]"),
                Arguments.of(5, 6, 1, 4, "[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]")
        );
    }

}