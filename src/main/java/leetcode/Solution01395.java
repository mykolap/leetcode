package leetcode;

/**
 * 1395. Count Number of Teams
 * <a href="https://leetcode.com/problems/count-number-of-teams">Web link</a>
 * Medium
 */

public class Solution01395 {

    public int numTeams(int[] rating) {
        int n = rating.length;
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            int leftLess = 0;
            int leftGreater = 0;
            int rightLess = 0;
            int rightGreater = 0;
            for (int j = 0; j < i; j++) {
                if (rating[j] < rating[i]) {
                    leftLess++;
                } else if (rating[j] > rating[i]) {
                    leftGreater++;
                }
            }
            for (int j = i + 1; j < n; j++) {
                if (rating[j] < rating[i]) {
                    rightLess++;
                } else if (rating[j] > rating[i]) {
                    rightGreater++;
                }
            }
            count += leftLess * rightGreater + leftGreater * rightLess;
        }
        return count;
    }

}