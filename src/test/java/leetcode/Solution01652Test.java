package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01652Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void decrypt(String codeStr, int k, String expectedStr) {
        int[] code = ArrayUtils.stringToIntArray(codeStr);
        int[] actual = new Solution01652().decrypt(code, k);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,7,1,4]", 3, "[12,10,16,13]"),
                Arguments.of("[1,2,3,4]", 0, "[0,0,0,0]"),
                Arguments.of("[2,4,9,3]", -2, "[12,5,6,13]")
        );
    }

}