package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class Solution00206Test {

    @Test
    void reverseList_returnsCorrectOutput_forFiveNodes() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);

        ListNode result = new Solution00206().reverseList(head);

        assertThat(result).hasToString("[5, 4, 3, 2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forFiveNodes() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);

        ListNode result = new Solution00206().reverseListRecursive(head);

        assertThat(result).hasToString("[5, 4, 3, 2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutput_forTwoNodes() {
        ListNode head = ListNode.of(1, 2);

        ListNode result = new Solution00206().reverseList(head);

        assertThat(result).hasToString("[2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forTwoNodes() {
        ListNode head = ListNode.of(1, 2);

        ListNode result = new Solution00206().reverseListRecursive(head);

        assertThat(result).hasToString("[2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutput_forSingleNode() {
        ListNode head = new ListNode(1);

        ListNode result = new Solution00206().reverseList(head);

        assertThat(result).hasToString("[1]");
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forSingleNode() {
        ListNode head = new ListNode(1);

        ListNode result = new Solution00206().reverseListRecursive(head);

        assertThat(result).hasToString("[1]");
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