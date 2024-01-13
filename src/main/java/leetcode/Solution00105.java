package leetcode;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 105. Construct Binary Tree from Preorder and Inorder Traversal
 * Medium
 * <p>
 * Share
 * Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder
 * is the inorder traversal of the same tree, construct and return the binary tree.
 * <p>
 * Example 1:
 * <p>
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * <p>
 * Example 2:
 * <p>
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * <p>
 * Constraints:
 * <p>
 * 1 <= preorder.length <= 3000
 * inorder.length == preorder.length
 * -3000 <= preorder[i], inorder[i] <= 3000
 * preorder and inorder consist of unique values.
 * Each value of inorder also appears in preorder.
 * preorder is guaranteed to be the preorder traversal of the tree.
 * inorder is guaranteed to be the inorder traversal of the tree.
 */
public class Solution00105 {

    // Time: O(n)
    // Space: O(n)
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int inStart, int inEnd) {
        if (preStart >= preorder.length || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = inStart;
        while (inIndex <= inEnd && inorder[inIndex] != preorder[preStart]) {
            inIndex++;
        }

        root.left = buildTree(preorder, inorder, preStart + 1, inStart, inIndex - 1);
        final int inPreDiff = inIndex - inStart;
        root.right = buildTree(preorder, inorder, preStart + inPreDiff + 1, inIndex + 1, inEnd);
        return root;
    }

    // Time: O(n)
    // Space: O(n)
    public TreeNode buildTreeWithMap(int[] preorder, int[] inorder) {
        final int arrLen = inorder.length;
        final Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < arrLen; i++) {
            inOrderMap.put(inorder[i], i);
        }

        return buildTreeWithMap(preorder, 0, arrLen - 1,
                inOrderMap, 0, arrLen - 1
        );
    }

    private TreeNode buildTreeWithMap(int[] preorder, int preStart, int preEnd,
                                      Map<Integer, Integer> inOrderMap, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // create the root node, which is the first node in preorder
        TreeNode root = new TreeNode(preorder[preStart]);

        // find the root node in in_order
        int inRoot = inOrderMap.get(root.val);

        // now , all the left side values in in_order is left tree, so calculate the index
        int leftNodeIndexIn = inRoot - inStart;

        // set the left node
        root.left = buildTreeWithMap(preorder, preStart + 1, preStart + leftNodeIndexIn,
                inOrderMap, inStart, inRoot - 1);

        //set the right node
        root.right = buildTreeWithMap(preorder, preStart + leftNodeIndexIn + 1, preEnd,
                inOrderMap, inRoot + 1, inEnd);

        return root;
    }

}
