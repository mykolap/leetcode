package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 * <a href="https://leetcode.com/problems/lexicographical-numbers">Web link</a>
 * Medium
 */

public class Solution00386 {

    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>(n);
        int current = 1;
        while (result.size() < n) {
            result.add(current);
            if (current * 10 <= n) {
                current *= 10;
            } else {
                while (current == n || current % 10 == 9) {
                    current /= 10;
                }
                current++;
            }
        }
        return result;
    }

}