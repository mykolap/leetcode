/**
 * 1346. Check If N and Its Double Exist
 * <a href="https://leetcode.com/problems/check-if-n-and-its-double-exist">Web link</a>
 * Easy
 */

package leetcode;

import java.util.HashSet;
import java.util.Set;

public class Solution01346 {

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int elem : arr) {
            if (set.contains(elem * 2)) {
                return true;
            }
            if (elem % 2 == 0 && set.contains(elem / 2)) {
                return true;
            }
            set.add(elem);
        }
        return false;
    }

}