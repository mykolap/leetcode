package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02022Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void construct2DArray(String originalStr, int m, int n, String expectedStr) {
        int[] original = ArrayUtils.stringToIntArray(originalStr);
        int[][] result = new Solution02022().construct2DArray(original, m, n);
        assertThat(Arrays.deepToString(result).replace(" ", "")).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,4]", 2, 2, "[[1,2],[3,4]]"),
                Arguments.of("[1,2]", 1, 1, "[]"),
                Arguments.of("[1,2]", 1, 2, "[[1,2]]"),
                Arguments.of("[1,2,3]", 1, 3, "[[1,2,3]]"),
                Arguments.of("[1,2,3]", 2, 2, "[]")
        );
    }

}