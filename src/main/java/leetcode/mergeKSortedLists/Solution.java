package leetcode.mergeKSortedLists;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 * 23. Merge k Sorted Lists
 * <p>
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * <p>
 * Merge all the linked-lists into one sorted linked-list and return it.
 * <p>
 * Example 1:
 * <p>
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * <p>
 * Example 2:
 * <p>
 * Input: lists = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: lists = [[]]
 * Output: []
 * <p>
 * Constraints:
 * <p>
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] is sorted in ascending order.
 * The sum of lists[i].length won't exceed 10^4.
 */
public class Solution {

    public static void main(String[] args) {
        ListNode[] lists = {
                new ListNode(1,
                        new ListNode(4,
                                new ListNode(5))),
                new ListNode(1,
                        new ListNode(3,
                                new ListNode(4))),
                new ListNode(2,
                        new ListNode(6))
        };

        ListNode result = new Solution().mergeKLists(lists);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    // Time: O(n * log(k))
    // Space: O(1)
    public ListNode mergeKLists(ListNode[] lists) {
        // If the array is null or empty, return null.
        if (lists == null || lists.length == 0) {
            return null;
        }

        // Create a priority queue to store the first node of each list.
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }

        // Create a dummy node to store the head of the merged list.
        ListNode dummyHead = new ListNode(0);

        ListNode current = dummyHead;
        while (!pq.isEmpty()) {
            // Get the node with the smallest value from the priority queue.
            ListNode node = pq.poll();
            current.next = node;
            current = current.next;

            // Add the next node of the list to the priority queue.
            if (node.next != null) {
                pq.add(node.next);
            }
        }

        return dummyHead.next;
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
