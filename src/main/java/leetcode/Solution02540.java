package leetcode;

/**
 * 2540. Minimum Common Value
 * https://leetcode.com/problems/minimum-common-value/
 * Easy
 */

public class Solution02540 {

    // Time: O(n)
    // Space: O(1)
    public int getCommon(int[] nums1, int[] nums2) {
        int leftIndex1 = 0;
        int leftIndex2 = 0;
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        while (leftIndex1 < n1 && leftIndex2 < n2) {
            if (nums1[leftIndex1] == nums2[leftIndex2]) {
                return nums1[leftIndex1];
            }
            if (nums1[leftIndex1] < nums2[leftIndex2]) {
                leftIndex1++;
            } else {
                leftIndex2++;
            }
        }
        return -1;
    }

}