package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 590. N-ary Tree Postorder Traversal
 * <a href="https://leetcode.com/problems/n-ary-tree-postorder-traversal">Web link</a>
 * Easy
 */

public class Solution00590 {

    public class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }

        if (root.children != null) {
            for (Node child : root.children) {
                postorder(child, result);
            }
        }

        result.add(root.val);
    }

}