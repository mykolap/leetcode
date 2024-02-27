package leetcode;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * 13. Roman to Integer
 * Easy
 */
public class Solution00013 {

    // Time: O(n)
    // Space: O(1)
    public int romanToInt(String s) {
        // Create a variable to store the result.
        int result = 0;

        // Create a variable to store the previous value.
        int prev = 0;

        // Iterate over the string.
        final int n = s.length();
        for (int i = 0; i < n; i++) {
            // Get the current character.
            char c = s.charAt(i);

            // Get the value of the current character.
            int value = getValue(c);

            // If the value of the current character is greater than the previous value,
            if (value > prev) {
                result = result + value - 2 * prev; // Eg. IV, at position V we already have 1, and to add extra 3 to get 4 we need  + (5 - 2 * 1) = 4
            } else {
                result += value;
            }

            // Update the previous value.
            prev = value;
        }

        // Return the result.
        return result;
    }

    // Get the value of the character.
    private int getValue(char c) {
        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
