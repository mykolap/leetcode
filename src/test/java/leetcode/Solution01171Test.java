package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01171Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeZeroSumSublists(ListNode head, ListNode expected) {
        ListNode result = new Solution01171().removeZeroSumSublists(head);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void removeZeroSumSublistsMap(ListNode head, ListNode expected) {
        ListNode result = new Solution01171().removeZeroSumSublistsMap(head);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, -3, 3, 1), ListNode.of(3, 1)),
                Arguments.of(ListNode.of(1, 2, 3, -3, 4), ListNode.of(1, 2, 4)),
                Arguments.of(ListNode.of(1, 2, 3, -3, -2), ListNode.of(1)),
                Arguments.of(ListNode.of(1, 3, 2, -3, -2, 5, 5, -5, 1), ListNode.of(1, 5, 1))
        );
    }

}