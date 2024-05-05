package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00152Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxProduct(String input, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(input);
        assertThat(new Solution00152().maxProduct(nums)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxProductOptimized(String input, int expected) {
        int[] nums = ArrayUtils.stringToIntArray(input);
        assertThat(new Solution00152().maxProductOptimized(nums)).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[2,3,-2,4]", 6),
                Arguments.of("[-2,0,-1]", 0),
                Arguments.of("[-2,0,-1,0,0,-3]", 0),
                Arguments.of("[-2,0,-1,0,0,-3,-4]", 12),
                Arguments.of("[0,2]", 2),
                Arguments.of("[-2,3,-4]", 24),
                Arguments.of("[3,-1,4]", 4)
        );
    }
}