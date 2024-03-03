package leetcode;


import leetcode.common.ListNode;

/**
 * 92. Reverse Linked List II
 * https://leetcode.com/problems/reverse-linked-list-ii/
 * Medium
 */

public class Solution00092 {

    // Time: O(n)
    // Space: O(1)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node to store the head of the reversed list.
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        // Create a pointer to the node before the sublist to be reversed.
        ListNode beforeSublist = dummyHead;
        for (int i = 0; i < left - 1; i++) {
            beforeSublist = beforeSublist.next;
        }

        // Create a pointer to the start of the sublist to be reversed.
        ListNode sublistStart = beforeSublist.next;

        // Create a pointer to the node after the sublist to be reversed.
        ListNode sublistEnd = sublistStart;
        for (int i = left; i < right; i++) {
            sublistEnd = sublistEnd.next;
        }

        // Create a pointer to the node after the sublist to be reversed.
        ListNode afterSublist = sublistEnd.next;

        // Break the sublist to be reversed from the rest of the list.
        sublistEnd.next = null;

        // Reverse the sublist to be reversed.
        reverse(sublistStart);

        // Reconnect the reversed sublist to the rest of the list.
        beforeSublist.next = sublistEnd;
        sublistStart.next = afterSublist;

        return dummyHead.next;
    }

    private void reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }

}