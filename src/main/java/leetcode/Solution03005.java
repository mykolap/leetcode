package leetcode;

/**
 * 3005. Count Elements With Maximum Frequency
 * <a href="https://leetcode.com/problems/count-elements-with-maximum-frequency/">...</a>
 * Easy
 */

public class Solution03005 {

    // Time: O(n)
    // Space: O(n)
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for (int num : nums) {
            freq[num]++;
        }
        int maxFreq = 0;
        int totalFrequences = 0;
        for (int f : freq) {
            if (f > maxFreq) {
                maxFreq = f;
                totalFrequences = f;
            } else if (f == maxFreq) {
                totalFrequences += f;
            }
        }
        return totalFrequences;
    }

}