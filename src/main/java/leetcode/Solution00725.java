package leetcode;

import leetcode.common.ListNode;

/**
 * 725. Split Linked List in Parts
 * <a href="https://leetcode.com/problems/split-linked-list-in-parts">Web link</a>
 * Medium
 */

public class Solution00725 {

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        int partSize = len / k;
        int extra = len % k;
        ListNode[] parts = new ListNode[k];
        curr = head;
        for (int i = 0; i < k; i++) {
            ListNode dummy = new ListNode(-1, curr);
            ListNode prev = dummy;
            final int subSize;
            if (i < extra) {
                subSize = partSize + 1;
            } else {
                subSize = partSize;
            }
            for (int j = 0; j < subSize; j++) {
                prev = curr;
                curr = curr.next;
            }
            prev.next = null;
            parts[i] = dummy.next;
        }
        return parts;
    }

}