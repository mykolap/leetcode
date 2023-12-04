package leetcode.removeNthNodeFromEndOfList;

import leetcode.common.ListNode;

/**
 * 19. Remove Nth Node From End of List
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p>
 * Medium
 * <p>
 * 4752
 * <p>
 * 291
 * <p>
 * Add to List
 * <p>
 * Share
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * <p>
 * Follow up: Could you do this in one pass?
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: head = [1,2,3,4,5], n = 2
 * Output: [1,2,3,5]
 * Example 2:
 * <p>
 * Input: head = [1], n = 1
 * Output: []
 * Example 3:
 * <p>
 * Input: head = [1,2], n = 1
 * Output: [1]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is sz.
 * 1 <= sz <= 30
 * 0 <= Node.val <= 100
 * 1 <= n <= sz
 */
public class Solution {

    // Time: O(n)
    // Space: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create two pointers, left and right
        ListNode left = head;
        ListNode right = head;

        // Move right n nodes ahead of left
        for (int i = 0; i < n; i++) {
            right = right.next;
        }

        // If right is null, it means that the node to be removed is the head
        if (right == null) {
            return head.next;
        }

        // Move left and right one node at a time until right reaches the end of the list
        while (right.next != null) {
            left = left.next;
            right = right.next;
        }

        // Remove the node
        left.next = left.next.next;

        return head;
    }

}
