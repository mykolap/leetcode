package leetcode;

import leetcode.common.ArrayUtils;
import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02058Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void nodesBetweenCriticalPoints(String headStr, String expectedStr) {
        ListNode head = ListNode.of(headStr);
        int[] result = new Solution02058().nodesBetweenCriticalPoints(head);
        assertThat(ArrayUtils.intArrayToString(result))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[3,1]", "[-1,-1]"),
                Arguments.of("[5,3,1,2,5,1,2]", "[1,3]"),
                Arguments.of("[1,3,2,2,3,2,2,2,7]", "[3,3]"),
                Arguments.of("[6,8,4,1,9,6,6,10,6]", "[1,6]")
        );
    }

}