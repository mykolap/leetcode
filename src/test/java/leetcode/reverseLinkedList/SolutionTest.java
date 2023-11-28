package leetcode.reverseLinkedList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class SolutionTest {

    @Test
    void reverseList_returnsCorrectOutput_forFiveNodes() {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1,
                new Solution.ListNode(2,
                        new Solution.ListNode(3,
                                new Solution.ListNode(4,
                                        new Solution.ListNode(5)))));

        Solution.ListNode expected = new Solution.ListNode(5,
                new Solution.ListNode(4,
                        new Solution.ListNode(3,
                                new Solution.ListNode(2,
                                        new Solution.ListNode(1)))));

        Solution.ListNode result = solution.reverseList(head);
        assertEquals(expected, result);
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forFiveNodes() {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1,
                new Solution.ListNode(2,
                        new Solution.ListNode(3,
                                new Solution.ListNode(4,
                                        new Solution.ListNode(5)))));

        Solution.ListNode expected = new Solution.ListNode(5,
                new Solution.ListNode(4,
                        new Solution.ListNode(3,
                                new Solution.ListNode(2,
                                        new Solution.ListNode(1)))));

        Solution.ListNode result = solution.reverseListRecursive(head);
        assertEquals(expected, result);
    }

    @Test
    void reverseList_returnsCorrectOutput_forTwoNodes() {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1,
                new Solution.ListNode(2));

        Solution.ListNode expected = new Solution.ListNode(2,
                new Solution.ListNode(1));

        Solution.ListNode result = solution.reverseList(head);
        assertEquals(expected, result);
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forTwoNodes() {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1,
                new Solution.ListNode(2));

        Solution.ListNode expected = new Solution.ListNode(2,
                new Solution.ListNode(1));

        Solution.ListNode result = solution.reverseListRecursive(head);
        assertEquals(expected, result);
    }

    @Test
    void reverseList_returnsCorrectOutput_forSingleNode() {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1);

        Solution.ListNode expected = new Solution.ListNode(1);

        Solution.ListNode result = solution.reverseList(head);
        assertEquals(expected, result);
    }

    @Test
    void reverseList_returnsCorrectOutputRecursive_forSingleNode() {
        Solution solution = new Solution();
        Solution.ListNode head = new Solution.ListNode(1);

        Solution.ListNode expected = new Solution.ListNode(1);

        Solution.ListNode result = solution.reverseListRecursive(head);
        assertEquals(expected, result);
    }

    @Test
    void reverseList_returnsNull_forNullInput() {
        Solution solution = new Solution();
        Solution.ListNode head = null;

        Solution.ListNode result = solution.reverseList(head);
        assertNull(result);
    }

    @Test
    void reverseList_returnsNullRecursive_forNullInput() {
        Solution solution = new Solution();
        Solution.ListNode head = null;

        Solution.ListNode result = solution.reverseListRecursive(head);
        assertNull(result);
    }

}