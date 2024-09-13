package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01310Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void xorQueries(String arrStr, String queriesStr, String expectedStr) {
        int[] arr = ArrayUtils.stringToIntArray(arrStr);
        int[][] queries = ArrayUtils.stringTo2DIntArray(queriesStr);
        int[] actual = new Solution01310().xorQueries(arr, queries);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        "[1,3,4,8]",
                        "[[0,1],[1,2],[0,3],[3,3]]",
                        "[2,7,14,8]"
                ),
                Arguments.of(
                        "[4,8,2,10]",
                        "[[2,3],[1,3],[0,0],[0,3]]",
                        "[8,0,4,4]"
                )
        );
    }

}