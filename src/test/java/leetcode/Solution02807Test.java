package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02807Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void insertGreatestCommonDivisors(String headStr, String expectedStr) {
        ListNode head = ListNode.of(headStr);
        ListNode result = new Solution02807().insertGreatestCommonDivisors(head);
        assertThat(result).hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[18,6,10,3]", "[18,6,6,2,10,1,3]"),
                Arguments.of("[7]", "[7]")
        );
    }

}