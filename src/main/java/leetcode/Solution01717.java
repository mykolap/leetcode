package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

/**
 * 1717. Maximum Score From Removing Substrings
 * <a href="https://leetcode.com/problems/maximum-score-from-removing-substrings">Web link</a> |
 * Medium
 */

public class Solution01717 {

    public int maximumGain(String s, int x, int y) {
        if (x > y) {
            return maximumGain(s, x, y, 'a', 'b');
        } else {
            return maximumGain(s, y, x, 'b', 'a');
        }
    }

    public int maximumGain(String s, int x, int y, char prefferedChar, char otherChar) {
        int n = s.length();
        int result = 0;
        Deque<Character> firstStack = new ArrayDeque<>();
        for (int i = 0; i < n; ++i) {
            char ch = s.charAt(i);
            result += addPairToResult(ch, x, prefferedChar, otherChar, firstStack);
        }
        Deque<Character> secondStack = new ArrayDeque<>();
        Iterator<Character> it = firstStack.descendingIterator();
        while (it.hasNext()) {
            char ch = it.next();
            result += addPairToResult(ch, y, otherChar, prefferedChar, secondStack);
        }
        return result;
    }

    private static int addPairToResult(char ch, int cost, char firstChar, char secondChar, Deque<Character> stack) {
        if (ch == secondChar
            && !stack.isEmpty()
            && stack.peek() == firstChar) {
            stack.pop();
            return cost;
        } else {
            stack.push(ch);
            return 0;
        }
    }

    public int maximumGainOptimal(String s, int x, int y) {
        // Ensure "ab" always has higher points than "ba"
        if (x < y) {
            // Swap points
            int temp = x;
            x = y;
            y = temp;
            // Reverse the string to maintain logic
            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0, bCount = 0, totalPoints = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (currentChar == 'a') {
                aCount++;
            } else if (currentChar == 'b') {
                if (aCount > 0) {
                    // Can form "ab", remove it and add points
                    aCount--;
                    totalPoints += x;
                } else {
                    // Can't form "ab", keep 'b' for potential future 'ba'
                    bCount++;
                }
            } else {
                // Non 'a' or 'b' character encountered
                // Calculate points for any remaining 'ba' pairs
                totalPoints += Math.min(bCount, aCount) * y;
                // Reset counters for next segment
                aCount = bCount = 0;
            }
        }

        // Calculate points for any remaining "ba" pairs at the end
        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }

}