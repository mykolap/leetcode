package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01829Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void getMaximumXor(String numsStr, int maximumBit, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[] actual = new Solution01829().getMaximumXor(nums, maximumBit);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[0,1,1,3]", 2, "[0,3,2,3]"),
                Arguments.of("[2,3,4,7]", 3, "[5,2,6,5]"),
                Arguments.of("[0,1,2,2,5,7]", 3, "[4,3,6,4,6,7]")
        );
    }

}