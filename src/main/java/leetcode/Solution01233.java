/**
 * 1233. Remove Sub-Folders from the Filesystem
 * <a href="https://leetcode.com/problems/remove-sub-folders-from-the-filesystem">Web link</a> |
 * Medium
 */

package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution01233 {

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);
        List<String> result = new ArrayList<>();
        result.add(folder[0]);
        String currentValidFolder = folder[0] + "/";
        for (int i = 1; i < folder.length; i++) {
            if (!folder[i].startsWith(currentValidFolder)) {
                result.add(folder[i]);
                currentValidFolder = folder[i] + "/";
            }
        }
        return result;
    }

}