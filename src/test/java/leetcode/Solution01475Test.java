package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01475Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void finalPrices(String pricesStr, String expectedStr) {
        int[] prices = ArrayUtils.stringToIntArray(pricesStr);
        final int[] actual = new Solution01475().finalPrices(prices);
        assertThat(ArrayUtils.intArrayToString(actual))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[8,4,6,2,3]", "[4,2,4,2,3]"),
                Arguments.of("[1,2,3,4,5]", "[1,2,3,4,5]"),
                Arguments.of("[10,1,1,6]", "[9,0,1,6]")
        );
    }

}