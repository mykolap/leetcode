package leetcode;

import leetcode.common.ListNode;

/**
 * 876. Middle of the Linked List
 * <a href="https://leetcode.com/problems/middle-of-the-linked-list/">...</a>
 * Easy
 */
public class Solution00876 {

    // Time: O(n)
    // Space: O(1)
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}