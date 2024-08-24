package leetcode;

/**
 * 564. Find the Closest Palindrome
 * <a href="https://leetcode.com/problems/find-the-closest-palindrome">Web link</a>
 * Hard
 */

public class Solution00564 {

    public String nearestPalindromic(String n) {
        long number = Long.parseLong(n);
        if (number <= 10) return String.valueOf(number - 1);
        if (number == 11) return "9";

        int length = n.length();
        long leftHalf = Long.parseLong(n.substring(0, (length + 1) / 2));

        long[] palindromeCandidates = new long[5];
        palindromeCandidates[0] = generatePalindromeFromLeft(leftHalf - 1, length % 2 == 0);
        palindromeCandidates[1] = generatePalindromeFromLeft(leftHalf, length % 2 == 0);
        palindromeCandidates[2] = generatePalindromeFromLeft(leftHalf + 1, length % 2 == 0);
        palindromeCandidates[3] = (long) Math.pow(10, length - 1) - 1;
        palindromeCandidates[4] = (long) Math.pow(10, length) + 1;

        long nearestPalindrome = 0;
        long minDifference = Long.MAX_VALUE;

        for (long candidate : palindromeCandidates) {
            if (candidate == number) continue;
            long difference = Math.abs(candidate - number);
            if (difference < minDifference || (difference == minDifference && candidate < nearestPalindrome)) {
                minDifference = difference;
                nearestPalindrome = candidate;
            }
        }

        return String.valueOf(nearestPalindrome);
    }

    private long generatePalindromeFromLeft(long leftHalf, boolean isEvenLength) {
        long palindrome = leftHalf;
        if (!isEvenLength) leftHalf /= 10;
        while (leftHalf > 0) {
            palindrome = palindrome * 10 + leftHalf % 10;
            leftHalf /= 10;
        }
        return palindrome;
    }

    public String nearestPalindromicLargerSmaller(String n) {
        long ip = Long.parseLong(n);
        long small = smallest(String.valueOf(ip - 1));
        long large = larger(String.valueOf(ip + 1));
        if (large - ip < ip - small) return String.valueOf(large);
        else return String.valueOf(small);
    }

    private long larger(String n) {
        char[] data = n.toCharArray();
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            while (data[start] != data[end]) {
                incrementNumber(data, end);
            }
            start++;
            end--;
        }
        return Long.parseLong(String.valueOf(data));
    }

    private long smallest(String n) {
        char[] data = n.toCharArray();
        int start = 0;
        int end = data.length - 1;
        while (start < end) {
            while (data[start] != data[end]) {
                decrementNumber(data, end);
                if (data[0] == '0') return Long.parseLong(String.valueOf(data));
            }
            start++;
            end--;
        }
        return Long.parseLong(String.valueOf(data));
    }

    private void decrementNumber(char[] data, int i) {
        while (data[i] == '0') {
            data[i] = '9';
            i--;
        }
        data[i]--;
    }

    private void incrementNumber(char[] data, int i) {
        while (data[i] == '9') {
            data[i] = '0';
            i--;
        }
        data[i]++;
    }

}