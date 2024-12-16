package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution03264Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getFinalState(String numsStr, int k, int multiplier, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[] actual = new Solution03264().getFinalState(nums, k, multiplier);
        assertThat(ArrayUtils.intArrayToString(actual)).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,1,3,5,6]", 5, 2, "[8,4,6,5,6]"),
                Arguments.of("[1,2]", 3, 4, "[16,8]")
        );
    }

}