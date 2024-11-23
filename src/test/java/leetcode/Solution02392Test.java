package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02392Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void buildMatrix(int k, String rowConditionsStr, String colConditionsStr, String expectedStr) {
        int[][] rowConditions = ArrayUtils.stringToInt2DArray(rowConditionsStr);
        int[][] colConditions = ArrayUtils.stringToInt2DArray(colConditionsStr);

        int[][] actual = new Solution02392().buildMatrix(k, rowConditions, colConditions);

        assertThat(ArrayUtils.int2DArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, "[[1,2],[3,2]]", "[[2,1],[3,2]]", "[[3,0,0],[0,0,1],[0,2,0]]"),
                Arguments.of(3, "[[1,2],[2,3],[3,1],[2,3]]", "[[2,1]]", "[]")
        );
    }

}