package leetcode;

import leetcode.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2196. Create Binary Tree From Descriptions
 * <a href="https://leetcode.com/problems/create-binary-tree-from-descriptions">Web link</a> |
 * Medium
 */

public class Solution02196 {

    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            children.add(child);
            boolean isLeft = description[2] == 1;

            if (!nodes.containsKey(parent)) {
                nodes.put(parent, new TreeNode(parent));
            }
            if (!nodes.containsKey(child)) {
                nodes.put(child, new TreeNode(child));
            }

            if (isLeft) {
                nodes.get(parent).left = nodes.get(child);
            } else {
                nodes.get(parent).right = nodes.get(child);
            }
        }

        for (int[] description : descriptions) {
            int parent = description[0];
            if (!children.contains(parent)) {
                return nodes.get(parent);
            }
        }

        return null;
    }


}