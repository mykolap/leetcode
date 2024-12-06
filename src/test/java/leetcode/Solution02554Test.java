package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02554Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxCount(String bannedStr, int n, int maxSum, int expected) {
        int[] banned = ArrayUtils.stringToIntArray(bannedStr);
        int result = new Solution02554().maxCount(banned, n, maxSum);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,6,5]", 5, 6, 2),
                Arguments.of("[1,2,3,4,5,6,7]", 8, 1, 0),
                Arguments.of("[11]", 7, 50, 7)
        );
    }

}