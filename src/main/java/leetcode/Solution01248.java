package leetcode;

/**
 * 1248. Count Number of Nice Subarrays
 * <a href="https://leetcode.com/problems/count-number-of-nice-subarrays">Web link</a> |
 * Medium
 */

public class Solution01248 {

    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int medium = 0;
        int oddCount = 0;
        int niceCount = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] % 2 == 1) {
                oddCount++;
            }

            while (oddCount > k) {
                if (nums[left] % 2 == 1) {
                    oddCount--;
                }
                left++;
                medium = left;
            }

            if (oddCount == k) {
                while (medium <= right && nums[medium] % 2 == 0) {
                    medium++;
                }
                niceCount += (medium - left + 1);
            }
        }
        return niceCount;
    }

}