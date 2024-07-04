package leetcode;

import leetcode.common.ListNode;

/**
 * 2181. Merge Nodes in Between Zeros
 * <a href="https://leetcode.com/problems/merge-nodes-in-between-zeros/">Web link</a>
 * Medium
 */

public class Solution02181 {

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode sourceCursor = head;
        ListNode targetCursor = dummy;

        int sum = 0;
        while (sourceCursor != null) {
            if (sourceCursor.val != 0) {
                sum += sourceCursor.val;
            } else if (sum > 0) {
                targetCursor.next = new ListNode(sum);
                targetCursor = targetCursor.next;
                sum = 0;
            }
            sourceCursor = sourceCursor.next;
        }

        return dummy.next;
    }

}