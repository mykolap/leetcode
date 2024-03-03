package leetcode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 21. Merge Two Sorted Lists
 * <p>
 * Merge two sorted linked lists and return it as a sorted list.
 * The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example 1:
 * <p>
 * Input: l1 = [1,2,4], l2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [], l2 = []
 * Output: []
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [], l2 = [0]
 * Output: [0]
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both l1 and l2 are sorted in non-decreasing order.
 */
public class Solution00021 {

    // Time: O(n)
    // Space: O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Create a dummy node to store the head of the merged list.
        ListNode dummyHead = new ListNode();
        ListNode current = dummyHead;

        // Iterate over both lists and add the smaller node to the merged list.
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                // Add list1 to the result
                current.next = list1;

                // Move list1 forward
                list1 = list1.next;
            } else {
                // Add list2 to the result
                current.next = list2;

                // Move list2 forward
                list2 = list2.next;
            }

            // Move current forward
            current = current.next;
        }

        // Add remaining nodes
        current.next = list1 == null ? list2 : list1;

        // Return the head of the merged list.
        return dummyHead.next;
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
    }

}
