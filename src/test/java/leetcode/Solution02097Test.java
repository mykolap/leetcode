package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02097Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void validArrangement(String pairsStr, String expectedStr) {
        int[][] pairs = ArrayUtils.stringToInt2DArray(pairsStr);
        int[][] result = new Solution02097().validArrangement(pairs);
        assertThat(ArrayUtils.int2DArrayToString(result))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[5,1],[4,5],[11,9],[9,4]]", "[[11,9],[9,4],[4,5],[5,1]]"),
                Arguments.of("[[1,3],[3,2],[2,1]]", "[[1,3],[3,2],[2,1]]"),
                Arguments.of("[[1,2],[1,3],[2,1]]", "[[1,2],[2,1],[1,3]]")
        );
    }

}