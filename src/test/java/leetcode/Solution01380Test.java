package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01380Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void luckyNumbers(String matrixStr, String expected) {
        int[][] matrix = ArrayUtils.stringTo2DIntArray(matrixStr);
        Solution01380 solution = new Solution01380();
        var result = solution.luckyNumbers(matrix);
        assertThat(result.toString().replace(" ", "")).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void luckyNumbersOptimized(String matrixStr, String expected) {
        int[][] matrix = ArrayUtils.stringTo2DIntArray(matrixStr);
        Solution01380 solution = new Solution01380();
        var result = solution.luckyNumbersOptimized(matrix);
        assertThat(result.toString().replace(" ", "")).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[3,7,8],[9,11,13],[15,16,17]]", "[15]"),
                Arguments.of("[[1,10,4,2],[9,3,8,7],[15,16,17,12]]", "[12]"),
                Arguments.of("[[7,8],[1,2]]", "[7]")
        );
    }

}