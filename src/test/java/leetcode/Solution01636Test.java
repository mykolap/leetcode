package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01636Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void frequencySort(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);

        int[] actual = new Solution01636().frequencySort(nums);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void frequencySortOptimized(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);

        int[] actual = new Solution01636().frequencySortOptimized(nums);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void frequencySortOptimized2(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);

        int[] actual = new Solution01636().frequencySortOptimized2(nums);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,1,2,2,2,3]", "[3,1,1,2,2,2]"),
                Arguments.of("[2,3,1,3,2]", "[1,3,3,2,2]"),
                Arguments.of("[-1,1,-6,4,5,-6,1,4,1]", "[5,-1,4,4,-6,-6,1,1,1]")
        );
    }

}