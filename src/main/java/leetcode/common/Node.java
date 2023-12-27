package leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<>();
    }

    public Node(int _val, Node node1, Node node2) {
        val = _val;
        neighbors = new ArrayList<>();
        neighbors.add(node1);
        neighbors.add(node2);
    }
}
