package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01894Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void chalkReplacer(String chalkStr, int k, int expected) {
        Solution01894 solution01894 = new Solution01894();
        int[] chalk = ArrayUtils.stringToIntArray(chalkStr);
        int result = solution01894.chalkReplacer(chalk, k);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[5,1,5]", 22, 0),
                Arguments.of("[3,4,1,2]", 25, 1),
                Arguments.of("[1]", 1000000000, 0),
                Arguments.of("[1,2,3]", 1000000000, 2),
                Arguments.of("[1,2,3]", 1000000001, 2),
                Arguments.of("[1,2,3]", 1000000002, 0)
        );
    }

}