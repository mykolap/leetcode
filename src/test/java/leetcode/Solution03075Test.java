package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03075Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumHappinessSum(String happinessStr, int k, long expected) {
        Solution03075 solution = new Solution03075();
        long actual = solution.maximumHappinessSum(ArrayUtils.stringToIntArray(happinessStr), k);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3]", 2, 4),
                Arguments.of("[1,1,1,1]", 2, 1),
                Arguments.of("[2,3,4,5]", 1, 5),
                Arguments.of("[7,50,3]", 3, 57)
        );
    }
}