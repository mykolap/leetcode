package leetcode.reverseLinkedList;

import leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 206. Reverse Linked List
 * <p>
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2]
 * Output: [2,1]
 * <p>
 * Example 3:
 * <p>
 * Input: head = []
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is the range [0, 5000].
 * -5000 <= Node.val <= 5000
 * <p>
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Solution {

    // Time: O(n)
    // Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while (current != null) {
            // Save next node
            ListNode next = current.next;

            // Reverse current node
            current.next = previous;

            // Move pointers
            previous = current;
            current = next;
        }

        return previous;
    }

    // Time: O(n)
    // Space: O(n)
    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversed = reverseListRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return reversed;
    }

}
