package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00846Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isNStraightHand(String handStr, int groupSize, boolean expected) {
        var solution = new Solution00846();
        var hand = ArrayUtils.stringToIntArray(handStr);
        var result = solution.isNStraightHand(hand, groupSize);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isNStraightHandOptimized(String handStr, int groupSize, boolean expected) {
        var solution = new Solution00846();
        var hand = ArrayUtils.stringToIntArray(handStr);
        var result = solution.isNStraightHandOptimized(hand, groupSize);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3,6,2,3,4,7,8]", 3, true),
                Arguments.of("[1,2,3,4,5]", 4, false),
                Arguments.of("[1,1,2,2,3,3]", 3, true)
        );
    }

}