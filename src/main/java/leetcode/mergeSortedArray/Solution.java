package leetcode.mergeSortedArray;

/**
 * https://leetcode.com/problems/merge-sorted-array/
 * 88. Merge Sorted Array
 * <p>
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6] Output: [1,2,2,3,5,6] Example 2:
 * <p>
 * Input: nums1 = [1], m = 1, nums2 = [] Output: [1]
 * <p>
 * Constraints:
 * <p>
 * nums1.length == m + n nums2.length == n 0 <= m, n <= 200 -109 <= nums1[i], nums2[i] <= 109
 */
public class Solution {

    // Time: O(n)
    // Space: O(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of the array.
        int lastIndexNum1 = m - 1;
        int lastIndexNum2 = n - 1;
        int lastIndexResult = m + n - 1;

        // While there are elements in both.
        while (lastIndexNum1 >= 0 && lastIndexNum2 >= 0) {
            if (nums1[lastIndexNum1] >= nums2[lastIndexNum2]) {
                nums1[lastIndexResult] = nums1[lastIndexNum1];
                lastIndexNum1--;
            } else { // nums1[lastIndexNum1] < nums2[lastIndexNum2]
                nums1[lastIndexResult] = nums2[lastIndexNum2];
                lastIndexNum2--;
            }
            lastIndexResult--;
        }

        // If there are still elements in nums2, then copy them to nums1.
        // if remaining elements are in num1 - they are already in target location
        if (lastIndexNum2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, lastIndexNum2 + 1);
        }
    }

    public void mergeSimpler(int[] nums1, int m, int[] nums2, int n) {
        // Start from the end of the array.
        int lastIndexNum1 = m - 1;
        int lastIndexNum2 = n - 1;
        int lastIndexResult = m + n - 1;

        // While there are elements in both.
        while (lastIndexNum2 >= 0) {
            if (lastIndexNum1 >= 0 && nums1[lastIndexNum1] > nums2[lastIndexNum2]) {
                nums1[lastIndexResult--] = nums1[lastIndexNum1--];
            } else { // nums1[lastIndexNum1] < nums2[lastIndexNum2] || lastIndexNum1 < 0
                nums1[lastIndexResult--] = nums2[lastIndexNum2--];
            }
        }
    }

}
