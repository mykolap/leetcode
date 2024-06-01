package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00260Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void singleNumber(String numsStr, String expectedStr) {
        int[] nums = ArrayUtils.stringToIntArray(numsStr);
        int[] expected = ArrayUtils.stringToIntArray(expectedStr);
        int[] actual = new Solution00260().singleNumber(nums);
        assertThat(actual)
                .containsExactlyInAnyOrder(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,1,3,2,5]", "[3,5]"),
                Arguments.of("[1,2,1,3,2,5,6,6]", "[3,5]")
        );
    }

}