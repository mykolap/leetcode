package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01140Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void stoneGameII(int expected, String pilesStr) {
        int[] piles = ArrayUtils.stringToIntArray(pilesStr);
        assertEquals(expected, new Solution01140().stoneGameII(piles));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(10, "[2,7,9,4,4]"),
                Arguments.of(104, "[1,2,3,4,5,100]"),
                Arguments.of(1, "[1]"),
                Arguments.of(3, "[1,2]"),
                Arguments.of(3, "[1,2,3]"),
                Arguments.of(5, "[1,2,3,4]")
        );
    }

}