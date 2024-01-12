package leetcode;

import leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/add-two-numbers/
 * 2. Add Two Numbers
 * <p>
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * <p>
 * Add the two numbers and return the sum as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero,
 * except the number 0 itself.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * <p>
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation:
 * 342 + 465 = 807
 * <p>
 * Example 2:
 * <p>
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * <p>
 * Example 3:
 * <p>
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in each linked list is in the range [1, 100].
 * <p>
 * 0 <= Node.val <= 9
 * <p>
 * It is guaranteed that the list represents a number that does not have leading zeros.
 */
public class Solution00002 {

    // Time: O(n)
    // Space: O(n)
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to store the head of the result linked list.
        ListNode dummy = new ListNode();
        // Create a pointer to the current node in the result linked list.
        ListNode current = dummy;
        // Create a variable to store the carry.
        int carry = 0;

        // Iterate over the linked lists l1 and l2 until we reach the end of both lists.
        while (l1 != null || l2 != null) {
            // Create a variable to store the sum of the current nodes in l1 and l2.
            int sum = carry;
            // If the current node in l1 is not null, add its value to the sum.
            if (l1 != null) {
                sum += l1.val;
                // Move the pointer to the next node in l1.
                l1 = l1.next;
            }
            // If the current node in l2 is not null, add its value to the sum.
            if (l2 != null) {
                sum += l2.val;
                // Move the pointer to the next node in l2.
                l2 = l2.next;
            }
            // Update the carry.
            carry = sum / 10;
            // Update the current node in the result linked list.
            current.next = new ListNode(sum % 10);
            // Move the pointer to the next node in the result linked list.
            current = current.next;
        }

        // If the carry is not zero, add a new node to the result linked list.
        if (carry != 0) {
            current.next = new ListNode(carry);
        }

        // Return the head of the result linked list.
        return dummy.next;
    }

}
