package leetcode;

import leetcode.common.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3217. Delete Nodes From Linked List Present in Array
 * <a href="https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array">Web link</a>
 * Medium
 */

public class Solution03217 {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numsSet = new HashSet<>(nums.length);
        for (int num : nums) {
            numsSet.add(num);
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = dummy.next;
        while (curr != null) {
            if (numsSet.contains(curr.val)) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

}