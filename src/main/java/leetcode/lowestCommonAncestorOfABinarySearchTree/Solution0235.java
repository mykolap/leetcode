package leetcode.lowestCommonAncestorOfABinarySearchTree;

import leetcode.common.TreeNode;

/**
 * <a href="https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/">
 * 235. Lowest Common Ancestor of a Binary Search Tree
 * </a>
 * <br/>
 * <div class="notranslate"><p>Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.</p>
 *
 * <p>According to the <a href="https://en.wikipedia.org/wiki/Lowest_common_ancestor" target="_blank">definition of LCA on Wikipedia</a>: “The lowest common ancestor is defined between two nodes <code>p</code> and <code>q</code> as the lowest node in <code>T</code> that has both <code>p</code> and <code>q</code> as descendants (where we allow <b>a node to be a descendant of itself</b>).”</p>
 *
 * <p><b>Example 1:</b></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png" style="width: 200px; height: 190px;">
 * <pre><b>Input:</b> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
 * <b>Output:</b> 6
 * <b>Explanation:</b> The LCA of nodes 2 and 8 is 6.
 * </pre>
 *
 * <p><b>Example 2:</b></p>
 * <img alt="" src="https://assets.leetcode.com/uploads/2018/12/14/binarysearchtree_improved.png" style="width: 200px; height: 190px;">
 * <pre><b>Input:</b> root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
 * <b>Output:</b> 2
 * <b>Explanation:</b> The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * </pre>
 *
 * <p><b>Example 3:</b
 * </p>
 * <pre><b>Input:</b> root = [2,1], p = 2, q = 1
 * <b>Output:</b> 2
 * </pre>
 * </div>
 * <p><strong>Constraints:</strong></p>
 * <ul>
 * <li>The number of nodes in the tree is in the range <code>[2, 10<sup>5</sup>]</code>.</li>
 * <li><code>-10<sup>9</sup> &lt;= Node.val &lt;= 10<sup>9</sup></code></li>
 * <li>All <code>Node.val</code> are <strong>unique</strong>.</li>
 * <li><code>p != q</code></li>
 * <li><code>p</code> and <code>q</code> will exist in the BST.</li>
 * </ul>
 * </div>
 */
public class Solution0235 {

    // Time: O(n)
    // Space: O(1)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            } else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }

    // Time: O(n)
    // Space: O(1)
    public TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {
        int small = Math.min(p.val, q.val);
        int large = Math.max(p.val, q.val);
        TreeNode current = root;
        while (current != null) {
            if (current.val > large) {
                current = current.left;
            } else if (current.val < small) {
                current = current.right;
            } else {
                return current;
            }
        }
        return null;
    }


}
