package leetcode.reverseLinkedList;

import leetcode.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    @Test
    void reverseList_returnsCorrectOutput_forFiveNodes() {
        Solution solution = new Solution();
        ListNode head = ListNode.fromVarArgArray(1, 2, 3, 4, 5);

        ListNode result = solution.reverseList(head);

        assertThat(result).hasToString("[5, 4, 3, 2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forFiveNodes() {
        Solution solution = new Solution();
        ListNode head = ListNode.fromVarArgArray(1, 2, 3, 4, 5);

        ListNode result = solution.reverseListRecursive(head);

        assertThat(result).hasToString("[5, 4, 3, 2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutput_forTwoNodes() {
        Solution solution = new Solution();
        ListNode head = ListNode.fromVarArgArray(1, 2);

        ListNode result = solution.reverseList(head);

        assertThat(result).hasToString("[2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forTwoNodes() {
        Solution solution = new Solution();
        ListNode head = ListNode.fromVarArgArray(1, 2);

        ListNode result = solution.reverseListRecursive(head);

        assertThat(result).hasToString("[2, 1]");
    }

    @Test
    void reverseList_returnsCorrectOutput_forSingleNode() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);

        ListNode result = solution.reverseList(head);

        assertThat(result).hasToString("[1]");
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forSingleNode() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);

        ListNode result = solution.reverseListRecursive(head);

        assertThat(result).hasToString("[1]");
    }

    @Test
    void reverseList_returnsNull_forNullInput() {
        Solution solution = new Solution();
        ListNode head = null;

        ListNode result = solution.reverseList(head);

        assertNull(result);
    }

    @Test
    void reverseList_returnsNullRecursive_forNullInput() {
        Solution solution = new Solution();
        ListNode head = null;

        ListNode result = solution.reverseListRecursive(head);

        assertNull(result);
    }

}