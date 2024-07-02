package leetcode;

import java.util.Arrays;

/**
 * 350. Intersection of Two Arrays II
 * <a href="https://leetcode.com/problems/intersection-of-two-arrays-ii">Web link</a>
 * Easy
 */

public class Solution00350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int pos1 = 0;
        int pos2 = 0;
        int posResult = 0;
        int[] resultMax = new int[nums1.length];
        while (pos1 < nums1.length && pos2 < nums2.length) {
            if (nums1[pos1] == nums2[pos2]) {
                resultMax[posResult] = nums1[pos1];
                ++pos1;
                ++pos2;
                ++posResult;
            } else if (nums1[pos1] < nums2[pos2]) {
                ++pos1;
            } else {
                ++pos2;
            }
        }
        int[] resultPrecise = new int[posResult];
        System.arraycopy(resultMax, 0, resultPrecise, 0, posResult);
        return resultPrecise;
    }

}