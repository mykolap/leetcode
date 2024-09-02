package leetcode;

/**
 * 1894. Find the Student that Will Replace the Chalk
 * <a href="https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk">Web link</a> |
 * Medium
 */

public class Solution01894 {

    public int chalkReplacer(int[] chalk, int k) {
        long totalChalk = 0;
        final int numStudents = chalk.length;

        // Calculate total chalk and reduce k in one loop
        for (int i = 0; i < numStudents; i++) {
            if (chalk[i] > k) return i;
            totalChalk += chalk[i];
            k -= chalk[i];
        }

        // Find the remainder of k when divided by the total chalk
        int remainingChalk = (int) (k % totalChalk);

        // Iterate through the chalk array to find the student
        for (int i = 0; i < numStudents; i++) {
            if (chalk[i] > remainingChalk) return i;
            remainingChalk -= chalk[i];
        }

        return 0;
    }

}