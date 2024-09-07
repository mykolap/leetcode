package leetcode;

import leetcode.common.ListNode;
import leetcode.common.TreeNode;

/**
 * 1367. Linked List in Binary Tree
 * <a href="https://leetcode.com/problems/linked-list-in-binary-tree">Web link</a>
 * Medium
 */

public class Solution01367 {

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (checkSubTree(head, root)) {
            return true;
        } else if (root == null) {
            return false;
        } else {
            return isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }

    private boolean checkSubTree(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        if (head.val != root.val) {
            return false;
        }
        return checkSubTree(head.next, root.left) || checkSubTree(head.next, root.right);
    }

}