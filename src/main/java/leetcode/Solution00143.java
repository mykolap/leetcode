package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. Reorder List
 * https://leetcode.com/problems/reorder-list/
 * <p>
 * Medium
 * <p>
 * 2516
 * <p>
 * 131
 * <p>
 * Add to List
 * <p>
 * Share
 * You are given the head of a singly linked-list. The list can be represented as:
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * Reorder the list to be on the following form:
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [1,2,3,4]
 * Output: [1,4,2,3]
 * Example 2:
 * <p>
 * Input: head = [1,2,3,4,5]
 * Output: [1,5,2,4,3]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the list is in the range [1, 5 * 104].
 * 1 <= Node.val <= 1000
 * <p>
 * Follow up: Can you solve the problem without modifying the list's values?
 */
public class Solution00143 {

    // Time: O(n)
    // Space: O(1)
    public void reorderList(ListNode head) {
        // Find the middle of the list and split it into two lists
        ListNode middle = findMiddleAndSplit(head);

        // Reverse the second half of the list
        ListNode reversed = reverse(middle);

        // Merge the two lists
        merge(head, reversed);
    }

    private ListNode findMiddleAndSplit(ListNode head) {
        // Create two pointers, slow and fast
        ListNode slow = head;
        ListNode fast = head.next;

        // Move slow one node at a time and fast two nodes at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // remember the middle node before splitting the list
        ListNode middle = slow.next;
        // Split the list
        slow.next = null;

        return middle;
    }

    private ListNode reverse(ListNode head) {
        // Create a dummy node to store the head of the reversed list
        ListNode dummyHead = new ListNode();

        // Iterate over the list and add each node to the front of the reversed list
        while (head != null) {
            // Store the next node
            ListNode next = head.next;

            // Add the current node to the front of the reversed list
            head.next = dummyHead.next;
            dummyHead.next = head;

            // Move head forward
            head = next;
        }

        // Return the head of the reversed list
        return dummyHead.next;
    }

    private void merge(ListNode list1, ListNode list2) {
        // Create a dummy node to store the head of the merged list
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        boolean addList1 = true;
        // Iterate over both lists and add from each list one element at a time
        while (list1 != null && list2 != null) {
            if (addList1) {
                // Add list1 to the result
                current.next = list1;

                // Move list1 forward
                list1 = list1.next;
                addList1 = false;
            } else {
                // Add list2 to the result
                current.next = list2;

                // Move list2 forward
                list2 = list2.next;
                addList1 = true;
            }
            // Move current forward
            current = current.next;
        }

        // Add remaining nodes
        current.next = list1 == null ? list2 : list1;
    }

    static class ListNode {
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

        @Override
        public String toString() {
            var head = this;
            List<Integer> values = new ArrayList<>();
            while (head != null) {
                values.add(head.val);
                head = head.next;
            }
            return values.toString();
        }
    }

}
