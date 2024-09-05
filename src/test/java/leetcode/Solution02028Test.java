package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02028Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void missingRolls(String rollsStr, int mean, int n, String expectedStr) {
        int[] rolls = ArrayUtils.stringToIntArray(rollsStr);
        int[] actual = new Solution02028().missingRolls(rolls, mean, n);
        assertThat(Arrays.toString(actual).replace(" ", "")).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,2,4,3]", 4, 2, "[6,6]"),
                Arguments.of("[1,5,6]", 3, 4, "[3,2,2,2]"),
                Arguments.of("[1,2,3,4]", 6, 4, "[]"),
                Arguments.of("[1]", 3, 1, "[5]")
        );
    }

}