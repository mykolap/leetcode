package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00066Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void plusOne(String digitsStr, String expectedStr) {
        int[] digits = ArrayUtils.stringToIntArray(digitsStr);
        assertThat(Arrays.toString(new Solution00066().plusOne(digits)).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3]", "[1,2,4]"),
                Arguments.of("[4,3,2,1]", "[4,3,2,2]"),
                Arguments.of("[0]", "[1]"),
                Arguments.of("[9]", "[1,0]"),
                Arguments.of("[9,9]", "[1,0,0]"),
                Arguments.of("[9,9,9]", "[1,0,0,0]")
        );
    }

}