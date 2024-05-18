package leetcode.common;

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

    public static TreeNode of(String treeStr) {
        if (treeStr == null || treeStr.isEmpty()) {
            return null;
        }

        String[] values = treeStr.replace("[", "").replace("]", "").split(",");
        if (values.length == 0 || values[0].equals("null")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < values.length; i += 2) {
            TreeNode parent = queue.poll();

            if (!values[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.offer(left);
            }

            if (i + 1 < values.length && !values[i + 1].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i + 1]));
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                sb.append("null");
            }
            if (!queue.isEmpty()) {
                sb.append(",");
            }
        }

        // Remove trailing nulls
        while (sb.length() >= 5 && sb.lastIndexOf(",null") == sb.length() - 5) {
            sb.delete(sb.length() - 5, sb.length());
        }

        sb.append("]");
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
