package leetcode;

/**
 * 214. Shortest Palindrome
 * <a href="https://leetcode.com/problems/shortest-palindrome">Web link</a>
 * Hard
 */

public class Solution00214 {

    public String shortestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";
        String rev = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < rev.length(); i++) {
            if (s.startsWith(rev.substring(i))) {
                return rev.substring(0, i) + s;
            }
        }
        return rev + s;
    }

}