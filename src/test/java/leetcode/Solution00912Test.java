package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00912Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sortArray(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);

        int[] result = new Solution00912().sortArray(nums);
        assertThat(Arrays.toString(result).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void sortArrayCountingSort(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);

        int[] result = new Solution00912().sortArrayCountingSort(nums);
        assertThat(Arrays.toString(result).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,2,3,1]", "[1,2,3,5]"),
                Arguments.of("[5,1,1,2,0,0]", "[0,0,1,1,2,5]")
        );
    }

}