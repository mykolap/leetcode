/**
 * 951. Flip Equivalent Binary Trees
 * <a href="https://leetcode.com/problems/flip-equivalent-binary-trees">Web link</a>
 * Medium
 */

package leetcode;

import leetcode.common.TreeNode;

public class Solution00951 {

    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        if (root1.val != root2.val) {
            return false;
        }
        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || // without flip
                (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left)); // or with flip
    }

}