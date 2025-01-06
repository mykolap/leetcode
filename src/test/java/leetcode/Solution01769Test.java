package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01769Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(String boxes, String expectedStr) {
        int[] result = new Solution01769().minOperations(boxes);
        assertThat(ArrayUtils.intArrayToString(result))
                .isEqualTo(expectedStr);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperationsOnePass(String boxes, String expectedStr) {
        int[] result = new Solution01769().minOperationsOnePass(boxes);
        assertThat(ArrayUtils.intArrayToString(result))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("110", "[1,1,3]"),
                Arguments.of("001011", "[11,8,5,4,3,4]")
        );
    }

}