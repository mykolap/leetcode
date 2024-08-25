package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 145. Binary Tree Postorder Traversal
 * <a href="https://leetcode.com/problems/binary-tree-postorder-traversal">Web link</a>
 * Easy
 */

public class Solution00145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        final List<Integer> list = new ArrayList<>();
        postorderTraversal(root, list);
        return list;
    }

    private void postorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        postorderTraversal(root.left, list);
        postorderTraversal(root.right, list);
        list.add(root.val);
    }

}