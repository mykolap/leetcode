package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00689Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxSumOfThreeSubarrays(String numsStr, int k, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[] result = new Solution00689().maxSumOfThreeSubarrays(nums, k);
        assertThat(ArrayUtils.intArrayToString(result))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,1,2,6,7,5,1]", 2, "[0,3,5]"),
                Arguments.of("[1,2,1,2,1,2,1,2,1]", 2, "[0,2,4]")
        );
    }

}