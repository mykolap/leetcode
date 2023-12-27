package leetcode.cloneGraph;

import leetcode.common.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * https://leetcode.com/problems/clone-graph/
 * 133. Clone Graph
 * <p>
 * Given a reference of a node in a connected undirected graph.
 * <p>
 * Return a deep copy (clone) of the graph.
 * <p>
 * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
 * <p>
 * class Node {
 * public int val;
 * public List<Node> neighbors;
 * }
 * <p>
 * Test case format:
 * <p>
 * For simplicity, each node's value is the same as the node's index (1-indexed).
 * For example, the first node with val == 1, the second node with val == 2, and so on.
 * The graph is represented in the test case using an adjacency list.
 * <p>
 * An adjacency list is a collection of unordered lists used to represent a finite graph.
 * Each list describes the set of neighbors of a node in the graph.
 * <p>
 * The given node will always be the first node with val = 1.
 * You must return the copy of the given node as a reference to the cloned graph.
 * <p>
 * Example 1:
 * <p>
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * <p>
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1) has neighbors 2 and 4.
 * 2nd node (val = 2) has neighbors 1 and 3.
 * 3rd node (val = 3) has neighbors 2 and 4.
 * 4th node (val = 4) has neighbors 1 and 3.
 * <p>
 * Example 2:
 * <p>
 * Input: adjList = [[]]
 * Output: [[]]
 * <p>
 * Explanation: Note that the input contains one empty list.
 * The graph consists of only one node with val = 1 and it does not have any neighbors.
 * <p>
 * Example 3:
 * <p>
 * Input: adjList = []
 * Output: []
 * <p>
 * Explanation: This an empty graph, it does not have any nodes.
 *
 *
 * Constraints:
 *
 * The number of nodes in the graph is in the range [0, 100].
 * 1 <= Node.val <= 100
 * Node.val is unique for each node.
 * There are no repeated edges and no self-loops in the graph.
 * The Graph is connected and all nodes can be visited starting from the given node.
 */
public class Solution0133 {

    // Time: O(n)
    // Space: O(n)
    public Node cloneGraphBfs(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> clonedNodes = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        clonedNodes.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            Node clonedCurrentNode = clonedNodes.get(currentNode);

            for (Node neighbor : currentNode.neighbors) {
                if (!clonedNodes.containsKey(neighbor)) {
                    clonedNodes.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }

                clonedCurrentNode.neighbors.add(clonedNodes.get(neighbor));
            }
        }

        return clonedNodes.get(node);
    }

    // Time: O(n)
    // Space: O(n)
    public Node cloneGraphDfs(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> clonedNodes = new HashMap<>();
        return cloneGraphDfs(node, clonedNodes);
    }

    private Node cloneGraphDfs(Node node, Map<Node, Node> clonedNodes) {
        final Node clonedNode = clonedNodes.get(node);
        if (clonedNode != null) {
            return clonedNode;
        }

        Node newClonedNode = new Node(node.val);
        clonedNodes.put(node, newClonedNode);

        for (Node neighbor : node.neighbors) {
            newClonedNode.neighbors.add(cloneGraphDfs(neighbor, clonedNodes));
        }

        return newClonedNode;
    }

}
