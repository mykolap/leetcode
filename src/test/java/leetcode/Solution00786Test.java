package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00786Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kthSmallestPrimeFraction(String strArr, int k, String expected) {
        int[] arr = ArrayUtils.stringToIntArray(strArr);
        int[] result = new Solution00786().kthSmallestPrimeFraction(arr, k);
        assertThat(ArrayUtils.intArrayToString(result)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void kthSmallestPrimeFractionOptimized(String strArr, int k, String expected) {
        int[] arr = ArrayUtils.stringToIntArray(strArr);
        int[] result = new Solution00786().kthSmallestPrimeFractionOptimized(arr, k);
        assertThat(ArrayUtils.intArrayToString(result)).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1, 2, 3, 5]", 3, "[2,5]"),
                Arguments.of("[1, 7]", 1, "[1,7]")
        );
    }

}