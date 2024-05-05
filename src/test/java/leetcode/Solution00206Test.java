package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class Solution00206Test {

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of("[1,2,3,4,5]"), "[5,4,3,2,1]"),
                Arguments.of(ListNode.of("[1]"), "[1]"),
                Arguments.of(ListNode.of("[1,2]"), "[2,1]")
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseListRecursive(ListNode head, String expected) {
        ListNode result = new Solution00206().reverseListRecursive(head);

        assertThat(result).hasToString(expected);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseList(ListNode head, String expected) {
        ListNode result = new Solution00206().reverseList(head);

        assertThat(result).hasToString(expected);
    }

    @Test
    void reverseList_returnsNull_forNullInput() {
        ListNode head = null;

        ListNode result = new Solution00206().reverseList(head);

        assertNull(result);
    }

    @Test
    void reverseList_returnsNullRecursive_forNullInput() {
        ListNode head = null;

        ListNode result = new Solution00206().reverseListRecursive(head);

        assertNull(result);
    }

}