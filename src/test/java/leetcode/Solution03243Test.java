package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution03243Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void shortestDistanceAfterQueries(int n, String queriesStr, String expectedStr) {
        int[][] queries = ArrayUtils.stringToInt2DArray(queriesStr);
        final int[] actual = new Solution03243().shortestDistanceAfterQueries(n, queries);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, "[[2,4],[0,2],[0,4]]", "[3,2,1]"),
                Arguments.of(4, "[[0,3],[0,2]]", "[1,1]")
        );
    }

}