package leetcode;

/**
 * <a href="https://leetcode.com/problems/number-of-laser-beams-in-a-bank/">
 * 2125. Number of Laser Beams in a Bank
 * Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.
 * <p>
 * There is one laser beam between any two security devices if both conditions are met:
 * <p>
 * The two devices are located on two different rows: r1 and r2, where r1 < r2.
 * For each row i where r1 < i < r2, there are no security devices in the ith row.
 * Laser beams are independent, i.e., one beam does not interfere nor join with another.
 * <p>
 * Return the total number of laser beams in the bank.
 * </p>
 * <p><strong>Example 1:</strong></p>
 * Input: bank = ["011001","000000","010100","001000"]
 * Output: 8
 * Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
 * bank[0][1] -- bank[2][1]
 * bank[0][1] -- bank[2][3]
 * bank[0][2] -- bank[2][1]
 * bank[0][2] -- bank[2][3]
 * bank[0][5] -- bank[2][1]
 * bank[0][5] -- bank[2][3]
 * bank[2][1] -- bank[3][2]
 * bank[2][3] -- bank[3][2]
 * Note that there is no beam between any device on the 0th row with any on the 3rd row.
 * This is because the 2nd row contains security devices, which breaks the second condition.
 *     <p><strong>Example 2:</strong></p>
 * Input: bank = ["000","111","000"]
 * Output: 0
 * Explanation: There does not exist two devices located on two different rows.
 */
public class Solution02125 {

    // Time: O(n)
    // Space: O(1)
    public int numberOfLaserBeamsInABank(String[] bank) {
        long previous = 0;
        long result = 0;

        for (String row : bank) {
            long current = row.chars().filter(charInt -> (char) charInt == '1').count();
            if (current > 0) {
                result += (previous * current);
                previous = current;
            }
        }

        return (int) result;
    }
}
