package leetcode;

import leetcode.common.ListNode;

import java.math.BigInteger;

/**
 * 2807. Insert Greatest Common Divisors in Linked List
 * <a href="https://leetcode.com/problems/insert-greatest-common-divisors-in-linked-list">Web link</a> |
 * Medium
 */

public class Solution02807 {

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode previous = head;
        ListNode current = head.next;
        while (current != null) {
            int gcd = gcd(previous.val, current.val);
            previous.next = new ListNode(gcd, current);
            previous = current;
            current = current.next;
        }
        return dummy.next;
    }

    private int gcd(int value1, int value2) {
        BigInteger bi1 = BigInteger.valueOf(value1);
        BigInteger bi2 = BigInteger.valueOf(value2);
        BigInteger gcd = bi1.gcd(bi2);
        return gcd.intValue();
    }

}