package leetcode;

import leetcode.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 2096. Step-By-Step Directions From a Binary Tree Node to Another
 * <a href="https://leetcode.com/problems/step-by-step-directions-from-a-binary-tree-node-to-another">Web link</a> |
 * Medium
 */

public class Solution02096 {

    public String getDirections(TreeNode root, int startValue, int destValue) {
        List<Character> startPath = new ArrayList<>();
        List<Character> destPath = new ArrayList<>();
        findPath(root, startValue, startPath);
        findPath(root, destValue, destPath);
        int commonAncestorIndex = findCommonAncestorIndex(startPath, destPath);
        return buildDirection(startPath.size() - commonAncestorIndex, destPath, commonAncestorIndex);
    }

    private boolean findPath(TreeNode node, int value, List<Character> path) {
        if (node == null) return false;
        if (node.val == value) return true;
        path.add('L');
        if (findPath(node.left, value, path)) return true;
        path.removeLast();
        path.add('R');
        if (findPath(node.right, value, path)) return true;
        path.removeLast();
        return false;
    }

    private int findCommonAncestorIndex(List<Character> startPath, List<Character> destPath) {
        int index = 0;
        while (index < startPath.size() && index < destPath.size() && startPath.get(index).equals(destPath.get(index))) {
            index++;
        }
        return index;
    }

    private String buildDirection(int upMoves, List<Character> destPath, int commonAncestorIndex) {
        StringBuilder direction = new StringBuilder();
        direction.append("U".repeat(upMoves));
        for (int i = commonAncestorIndex; i < destPath.size(); i++) {
            direction.append(destPath.get(i));
        }
        return direction.toString();
    }

}