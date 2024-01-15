package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 * 297. Serialize and Deserialize Binary Tree
 * Hard
 * <p>
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in
 * the same or another computer environment.
 * <p>
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 * to a string and this string can be deserialized to the original tree structure.
 * <p>
 * Clarification: The input/output format is the same as how LeetCode serializes a binary tree. You do not necessarily
 * need to follow this format, so please be creative and come up with different approaches yourself.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,null,4,5]
 * Output: [1,2,3,null,null,4,5]
 * Example 2:
 * Input: root = []
 * Output: []
 * Example 3:
 * Input: root = [1]
 * Output: [1]
 * Example 4:
 * Input: root = [1,2]
 * Output: [1,2]
 * Constraints:
 * The number of nodes in the tree is in the range [0, 104].
 * -1000 <= Node.val <= 1000
 */
public class Solution00297 {

    static interface Codec {
        // Encodes a tree to a single string.
        String serialize(TreeNode root);

        // Decodes your encoded data to tree.
        TreeNode deserialize(String data);
    }

    static class CodecBfs implements Codec {

        @Override
        public String serialize(TreeNode root) {
            if (root == null) {
                return "";
            }
            Queue<TreeNode> queue = new LinkedList<>();
            StringBuilder sb = new StringBuilder();
            queue.offer(root);
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                    continue;
                }
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            String[] nodes = data.split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            queue.offer(root);
            int index = 1;
            while (index < nodes.length) {
                TreeNode parent = queue.poll();
                int leftIndex = index;
                final String leftValue = nodes[leftIndex];
                if (!"null".equals(leftValue)) {
                    TreeNode left = new TreeNode(Integer.parseInt(leftValue));
                    parent.left = left;
                    queue.offer(left);
                }
                index++;
                int rightIndex = index;
                final String rightValue = nodes[rightIndex];
                if (!"null".equals(rightValue)) {
                    TreeNode right = new TreeNode(Integer.parseInt(rightValue));
                    parent.right = right;
                    queue.offer(right);
                }
                index++;
            }
            return root;
        }

    }

    static class CodecDfs implements Codec {

        @Override
        public String serialize(TreeNode root) {
            if (root == null) return "";
            List<String> result = new ArrayList<>();
            serializeDfs(root, result);
            return String.join(",", result);
        }

        @Override
        public TreeNode deserialize(String data) {
            if ("".equals(data)) {
                return null;
            }
            IndexHolder indexHolder = new IndexHolder();
            String[] nodes = data.split(",");
            return deserializeDfs(nodes, indexHolder);
        }

        private void serializeDfs(TreeNode root, List<String> result) {
            if (root == null) {
                result.add("null");
                return;
            }
            result.add(String.valueOf(root.val));
            serializeDfs(root.left, result);
            serializeDfs(root.right, result);
        }

        private TreeNode deserializeDfs(String[] nodes, IndexHolder indexHolder) {
            if ("null".equals(nodes[indexHolder.index])) {
                indexHolder.index++;
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(nodes[indexHolder.index]));
            indexHolder.index++;
            root.left = deserializeDfs(nodes, indexHolder);
            root.right = deserializeDfs(nodes, indexHolder);
            return root;
        }

        private static class IndexHolder {
            int index = 0;
        }

    }

}
