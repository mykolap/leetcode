package leetcode.reverseNodesInKGroup;

import leetcode.common.ListNode;

/**
 * <a href="https://leetcode.com/problems/reverse-nodes-in-k-group/">
 * 25. Reverse Nodes in k-Group
 * </a>
 * <br/>
 * <div class="notranslate"><p>Given a linked list, reverse the nodes of a linked list <em>k</em> at a time and return its modified list.</p>
 *
 * <p><em>k</em> is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of <em>k</em> then left-out nodes, in the end, should remain as it is.</p>
 *
 * <p>You may&nbsp;not alter the values in the list's nodes, only nodes themselves may be changed.</p>
 *
 * <p><strong>Example 1:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex1.jpg" style="width: 542px; height: 222px;">
 * <pre><strong>Input:</strong> head = [1,2,3,4,5], k = 2
 * <strong>Output:</strong> [2,1,4,3,5]
 * </pre>
 *
 * <p><strong>Example 2:</strong></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2020/10/03/reverse_ex2.jpg" style="width: 542px; height: 222px;">
 * <pre><strong>Input:</strong> head = [1,2,3,4,5], k = 3
 * <strong>Output:</strong> [3,2,1,4,5]
 * </pre>
 *
 * <p><strong>Example 3:</strong></p>
 *
 * <pre><strong>Input:</strong> head = [1,2,3,4,5], k = 1
 * <strong>Output:</strong> [1,2,3,4,5]
 * </pre>
 *
 * <p><strong>Example 4:</strong></p>
 *
 * <pre><strong>Input:</strong> head = [1], k = 1
 * <strong>Output:</strong> [1]
 * </pre>
 */
public class Solution0025 {

    // Time: O(n)
    // Space: O(1)
    public ListNode reverseKGroupRecursive(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the end of this group
            curr = curr.next;
            count++;
        }

        if (count == k) { // if the count is equal to k, reverse this group
            curr = reverseKGroupRecursive(curr, k); // reverse the rest of the list
            while (count-- > 0) { // reverse current group
                ListNode tmp = head.next; // tmp - next head in original list
                head.next = curr; // preappending "next head" to the reversed list
                curr = head; // move head of reversed list to a new node
                head = tmp; // move "next head" to the head of the remaining list
            }
            head = curr;
        }
        return head;
    }

    // Time: O(n)
    // Space: O(1)
    public ListNode reverseKGroupIterative(ListNode head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode groupPrev = dummy;

        while (true) {
            final ListNode kth = findK(k, groupPrev);
            if (kth == null) {
                break;
            }

            reverseGroup(groupPrev.next, kth.next);

            ListNode tmp = groupPrev.next;
            groupPrev.next = kth;
            groupPrev = tmp;
        }
        return dummy.next;
    }

    private static ListNode findK(int k, ListNode groupPrev) {
        ListNode kth = groupPrev;
        int count = 0;
        while (kth != null && count < k) {
            kth = kth.next;
            count++;
        }
        return kth;
    }

    private static void reverseGroup(ListNode start, ListNode end) {
        // reverse group
        ListNode prev = end;
        while (start != end) {
            ListNode tmp = start.next;
            start.next = prev;
            prev = start;
            start = tmp;
        }
    }

}
