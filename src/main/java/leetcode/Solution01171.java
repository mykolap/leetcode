package leetcode;

import leetcode.common.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 1171. Remove Zero Sum Consecutive Nodes from Linked List
 * <a href="https://leetcode.com/problems/remove-zero-sum-consecutive-nodes-from-linked-list">Web link</a>
 * Medium
 */

public class Solution01171 {

    // Time: O(n^2)
    // Space: O(1)
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current != null) {
            int sum = 0;
            ListNode next = current.next;
            while (next != null) {
                sum += next.val;
                if (sum == 0) {
                    current.next = next.next;
                }
                next = next.next;
            }
            current = current.next;
        }
        return dummy.next;
    }

    // Time: O(n)
    // Space: O(n)
    public ListNode removeZeroSumSublistsMap(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        int prefixSum = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        map.put(0, dummy);

        ListNode current = head;
        while (current != null) {
            prefixSum += current.val;
            map.put(prefixSum, current);
            current = current.next;
        }

        current = dummy;
        prefixSum = 0;
        while (current != null) {
            prefixSum += current.val;
            current.next = map.get(prefixSum).next;
            current = current.next;
        }

        return dummy.next;
    }

}