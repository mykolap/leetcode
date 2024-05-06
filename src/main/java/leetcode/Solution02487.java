package leetcode;

import leetcode.common.ListNode;

/**
 * 2487. Remove Nodes From Linked List
 * <a href="https://leetcode.com/problems/remove-nodes-from-linked-list">Web link</a> |
 * Medium
 */

public class Solution02487 {

    public ListNode removeNodes(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nextBigger = removeNodes(head.next);
        head.next = nextBigger;
        if (nextBigger == null || head.val >= nextBigger.val) {
            return head;
        }
        return nextBigger;
    }

}