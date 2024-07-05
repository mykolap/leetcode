package leetcode;

import leetcode.common.ListNode;

/**
 * 2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
 * <a href="https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points">Web link</a>
 * Medium
 */

public class Solution02058 {

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCriticalPoint = -1;
        int lastCriticalPoint = -1;

        ListNode cursor = head;

        int previousValue = cursor.val;
        cursor = cursor.next;
        int currentValue = cursor.val;
        cursor = cursor.next;
        int nextValue;
        int distancePos = 0;
        int minDistance = Integer.MAX_VALUE;
        while (cursor != null) {
            ++distancePos;
            nextValue = cursor.val;
            if ((currentValue > previousValue && currentValue > nextValue) ||
                (currentValue < previousValue && currentValue < nextValue)) {
                if (firstCriticalPoint == -1) {
                    firstCriticalPoint = distancePos;
                } else {
                    minDistance = Math.min(minDistance, distancePos - lastCriticalPoint);
                }
                lastCriticalPoint = distancePos;
            }
            previousValue = currentValue;
            currentValue = nextValue;
            cursor = cursor.next;
        }

        int[] result = new int[2];
        if (minDistance == Integer.MAX_VALUE) {
            result[0] = -1;
            result[1] = -1;
        } else {
            result[0] = minDistance;
            result[1] = lastCriticalPoint - firstCriticalPoint;
        }
        return result;
    }

}