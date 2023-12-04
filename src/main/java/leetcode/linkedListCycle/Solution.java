package leetcode.linkedListCycle;

import leetcode.common.ListNode;

/**
 * https://leetcode.com/problems/linked-list-cycle/
 * 141. Linked List Cycle
 * <p>
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * <p>
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 * <p>
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * <p>
 * Example 1:
 * <p>
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * <p>
 * Example 2:
 * <p>
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 0th node.
 * <p>
 * Example 3:
 * <p>
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 * <p>
 * Constraints:
 * <p>
 * The number of the nodes in the list is in the range [0, 104].
 * -105 <= Node.val <= 105
 * pos is -1 or a valid index in the linked-list.
 * <p>
 * Follow up: Can you solve it using O(1) (i.e. constant) memory?
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(3,
                new ListNode(2,
                        new ListNode(0,
                                new ListNode(-4))));

        head.next.next.next.next = head.next;

        System.out.println(new Solution().hasCycle(head));
    }

    // Time: O(n)
    // Space: O(1)
    public boolean hasCycle(ListNode head) {
        ListNode slowPointer = head;
        ListNode fastPointer = head;

        do {
            if (fastPointer == null || fastPointer.next == null) {
                return false;
            }

            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        } while (slowPointer != fastPointer);

        return true;
    }

}
