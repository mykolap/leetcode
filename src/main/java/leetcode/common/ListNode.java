package leetcode.common;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListNode {

    public boolean safeToString = false;
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode of(String input) {
        int[] intArr = ArrayUtils.stringToIntArray(input);
        return of(intArr);
    }

    public static ListNode of(int... array) {
        ListNode head = new ListNode(array[0]);
        ListNode current = head;

        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }

        return head;
    }

    @Override
    public String toString() {
        if (safeToString) {
            return "[" +
                   val +
                   ",...]";
        }
        var head = this;
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }
        return "[" + values.stream().map(String::valueOf).collect(Collectors.joining(",")) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ListNode other = (ListNode) obj;
        ListNode current = this;
        ListNode otherCurrent = other;
        while (current != null && otherCurrent != null) {
            if (current.val != otherCurrent.val) {
                return false;
            }
            current = current.next;
            otherCurrent = otherCurrent.next;
        }
        return current == null && otherCurrent == null;
    }

    @Override
    public int hashCode() {
        return val;
    }

}
