package leetcode.common;

import leetcode.Solution00104;

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

    public static TreeNode of(Integer... values) {
        if (values == null || values.length == 0 || values[0] == null) {
            return null;
        }

        TreeNode root = new TreeNode(values[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        for (int i = 1; i < values.length; i += 2) {
            TreeNode parent = queue.poll();

            if (values[i] != null) {
                TreeNode left = new TreeNode(values[i]);
                parent.left = left;
                queue.offer(left);
            }

            if (i + 1 < values.length && values[i + 1] != null) {
                TreeNode right = new TreeNode(values[i + 1]);
                parent.right = right;
                queue.offer(right);
            }
        }

        return root;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int height = new Solution00104().maxDepthRecursiveDfs(this);
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
