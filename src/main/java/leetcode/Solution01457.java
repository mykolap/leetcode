package leetcode;

import leetcode.common.TreeNode;

/**
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/description/
 * Medium
 * <p>
 * Given a binary tree where node values are digits from 1 to 9. A path in the binary tree is said to be pseudo-palindromic if at least one permutation of the node values in the path is a palindrome.
 * <p>
 * Return the number of pseudo-palindromic paths going from the root node to leaf nodes.
 * <p>
 * Example 1:
 * <p>
 * Input: root = [2,3,1,3,1,null,1]
 * Output: 2
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the red path [2,3,3], the green path [2,1,1], and the path [2,3,1]. Among these paths only red path and green path are pseudo-palindromic paths since the red path [2,3,3] can be rearranged in [3,2,3] (palindrome) and the green path [2,1,1] can be rearranged in [1,2,1] (palindrome).
 * Example 2:
 * <p>
 * Input: root = [2,1,1,1,3,null,null,null,null,null,1]
 * Output: 1
 * Explanation: The figure above represents the given binary tree. There are three paths going from the root node to leaf nodes: the green path [2,1,1], the path [2,1,3,1], and the path [2,1]. Among these paths only the green path is pseudo-palindromic since [2,1,1] can be rearranged in [1,2,1] (palindrome).
 * Example 3:
 * <p>
 * Input: root = [9]
 * Output: 1
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 105].
 * 1 <= Node.val <= 9
 */
public class Solution01457 {

    public int pseudoPalindromicPaths(TreeNode root) {
        int[] freq = new int[10];
        return dfs(root, freq);
    }

    private int dfs(TreeNode node, int[] freq) {
        if (node == null) {
            return 0;
        }

        freq[node.val]++;
        int count = 0;
        if (node.left == null && node.right == null) {
            if (isPseudoPalindromic(freq)) {
                count++;
            }
        } else {
            count += dfs(node.left, freq);
            count += dfs(node.right, freq);
        }
        freq[node.val]--;

        return count;
    }

    private boolean isPseudoPalindromic(int[] freq) {
        int oddCount = 0;
        for (int i = 1; i < 10; i++) {
            if (freq[i] % 2 != 0) {
                oddCount++;
            }
            if (oddCount > 1) {
                return false;
            }
        }
        return true;
    }

}