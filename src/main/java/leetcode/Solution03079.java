package leetcode;

/**
 * 3079. Find the Sum of Encrypted Integers
 * https://leetcode.com/problems/find-the-sum-of-encrypted-integers/description/
 * Easy
 */
public class Solution03079 {

    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += encrypt(num);
        }
        return sum;
    }

    private int encrypt(int num) {
        int maxDigit = 0;
        int length = 0;

        while (num > 0) {
            int digit = num % 10;
            maxDigit = Math.max(maxDigit, digit);
            num /= 10;
            length++;
        }

        int encrypted = 0;
        for (int i = 0; i < length; i++) {
            encrypted = encrypted * 10 + maxDigit;
        }
        return encrypted;
    }

    public int sumOfEncryptedIntViaString(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            String str = String.valueOf(num);
            char max = '0';
            for (char i : str.toCharArray()) {
                if (i > max) {
                    max = i;
                }
            }
            StringBuilder sb = new StringBuilder(str.length());
            sb.repeat(max, str.length());
            int digit = Integer.parseInt(sb.toString());
            sum += digit;
        }
        return sum;
    }

}
