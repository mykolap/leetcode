package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1382. Balance a Binary Search Tree
 * <a href="https://leetcode.com/problems/balance-a-binary-search-tree/">Web link</a>
 * Medium
 */

public class Solution01382 {

    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorderTraversal(root, inorderList);
        return buildBalancedBST(inorderList, 0, inorderList.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorderList) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left, inorderList);
        inorderList.add(root.val);
        inorderTraversal(root.right, inorderList);
    }

    private TreeNode buildBalancedBST(List<Integer> inorderList, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(inorderList.get(mid));
        root.left = buildBalancedBST(inorderList, left, mid - 1);
        root.right = buildBalancedBST(inorderList, mid + 1, right);
        return root;
    }

}