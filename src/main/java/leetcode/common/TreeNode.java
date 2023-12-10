package leetcode.common;

import leetcode.maximumDepthOfBinaryTree.Solution0104;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {

    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode fromVarargArray(Integer... array) {
        if (array.length == 0) {
            return null;
        }

        TreeNode root = addNodeIfValueNotNull(array[0]);
        TreeNode current = root;

        if (array.length > 1) {
            current.left = addNodeIfValueNotNull(array[1]);
            if (array.length > 3) {
                current.left.left = addNodeIfValueNotNull(array[3]);
            }
            if (array.length > 4) {
                current.left.right = addNodeIfValueNotNull(array[4]);
            }
        }
        if (array.length > 2) {
            current.right = TreeNode.fromVarargArray(array[2]);
            if (array.length > 5) {
                current.right.left = addNodeIfValueNotNull(array[5]);
            }
            if (array.length > 6) {
                current.right.right = addNodeIfValueNotNull(array[6]);

            }
        }
        return root;
    }

    private static TreeNode addNodeIfValueNotNull(Integer value) {
        if (value == null) {
            return null;
        }
        return new TreeNode(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int height = new Solution0104().maxDepth(this);
        int nodes = (int) Math.pow(2, height - 1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(this);

        for (int i = 0; i < height; i++) {
            int nodeCount = queue.size();
            boolean isAllNull = true;

            while (nodeCount > 0) {
                TreeNode node = queue.remove();
                printNode(node, nodes, sb);
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    if (isAllNull && (node.left != null || node.right != null)) {
                        isAllNull = false;
                    }
                } else {
                    queue.add(null);
                    queue.add(null);
                }
                nodeCount--;
            }
            sb.append("\n");
            if (isAllNull) {
                break;
            }
            nodes /= 2;
        }
        return sb.toString();
    }

    private void printNode(TreeNode node, int totalSpaces, StringBuilder sb) {
        int spaces = totalSpaces * 2;
        sb.repeat(" ", spaces - 1);
        if (node != null) {
            sb.append(node.val);
        } else {
            sb.append(" ");
        }
        sb.repeat(" ", spaces);
    }

}
