package leetcode;

import leetcode.common.ListNode;

/**
 * 2816. Double a Number Represented as a Linked List
 * <a href="https://leetcode.com/problems/double-a-number-represented-as-a-linked-list">Web link</a> |
 * Medium
 */

public class Solution02816 {

    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        reverseList(dummy);
        doubleList(dummy);
        reverseList(dummy);
        return dummy.next;
    }

    private void doubleList(ListNode dummy) {
        int carry = 0;
        ListNode prev = null;
        ListNode curr = dummy.next;
        while (curr != null) {
            curr.val = curr.val * 2 + carry;
            carry = curr.val / 10;
            curr.val = curr.val % 10;
            prev = curr;
            curr = prev.next;
        }
        if (carry > 0) {
            prev.next = new ListNode(carry);
        }
    }

    private void reverseList(ListNode dummy) {
        ListNode prev = null;
        ListNode curr = dummy.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        dummy.next = prev;
    }

}