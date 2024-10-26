/**
 * 2458. Height of Binary Tree After Subtree Removal Queries
 * <a href="https://leetcode.com/problems/height-of-binary-tree-after-subtree-removal-queries">Web link</a> |
 * Hard
 */

package leetcode;

import leetcode.common.TreeNode;

public class Solution02458 {

    public int[] treeQueries(TreeNode root, int[] queries) {
        int[] preOrderArr = new int[100001];
        int[] postOrderArr = new int[100001];
        int[] maxH = {0};

        preOrder(root, 0, preOrderArr, maxH);
        maxH[0] = 0;
        postOrder(root, 0, postOrderArr, maxH);

        int[] res = new int[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.max(preOrderArr[queries[i]], postOrderArr[queries[i]]);
        }
        return res;
    }

    private void preOrder(TreeNode root, int height, int[] preOrderArr, int[] maxH) {
        if (root == null) {
            return;
        }

        preOrderArr[root.val] = maxH[0];
        maxH[0] = Math.max(maxH[0], height);
        preOrder(root.left, height + 1, preOrderArr, maxH);
        preOrder(root.right, height + 1, preOrderArr, maxH);
    }

    private void postOrder(TreeNode root, int height, int[] postOrderArr, int[] maxH) {
        if (root == null) {
            return;
        }

        postOrderArr[root.val] = maxH[0];
        maxH[0] = Math.max(maxH[0], height);
        postOrder(root.right, height + 1, postOrderArr, maxH);
        postOrder(root.left, height + 1, postOrderArr, maxH);
    }

}