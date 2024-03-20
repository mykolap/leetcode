package leetcode;

import leetcode.common.ListNode;

/**
 * 1669. Merge In Between Linked Lists
 * https://leetcode.com/problems/merge-in-between-linked-lists/
 * Medium
 */

public class Solution01669 {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode currentNode = list1;
        for (int i = 0; i < a - 1; i++) {
            currentNode = currentNode.next;
        }
        ListNode postNode = currentNode;
        for (int i = a; i <= b + 1; i++) {
            postNode = postNode.next;
        }
        currentNode.next = list2;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        currentNode.next = postNode;
        return list1;
    }

}