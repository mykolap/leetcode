package leetcode.cloneGraph;

import leetcode.common.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class Solution0133Test {

    @Test
    void cloneGraphBfs_withSingleNode() {
        Node node1 = new Node(1);
        Node clonedNode = new Solution0133().cloneGraphBfs(node1);

        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    void cloneGraphBfs_withMultipleNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node clonedNode = new Solution0133().cloneGraphBfs(node1);

        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
        assertEquals(node1.neighbors.get(0).val, clonedNode.neighbors.get(0).val);
    }

    @Test
    void cloneGraphBfs_withNullNode() {
        Node clonedNode = new Solution0133().cloneGraphBfs(null);
        assertNull(clonedNode);
    }

    @Test
    void cloneGraphDfs_withSingleNode() {
        Node node1 = new Node(1);
        Node clonedNode = new Solution0133().cloneGraphDfs(node1);

        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }

    @Test
    void cloneGraphDfs_withMultipleNodes() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.neighbors.add(node2);
        node2.neighbors.add(node1);

        Node clonedNode = new Solution0133().cloneGraphDfs(node1);

        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
        assertEquals(node1.neighbors.get(0).val, clonedNode.neighbors.get(0).val);
    }

    @Test
    void cloneGraphDfs_withNullNode() {
        Node clonedNode = new Solution0133().cloneGraphDfs(null);
        assertNull(clonedNode);
    }

}