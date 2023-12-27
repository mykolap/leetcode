package leetcode.cloneGraph;

import leetcode.common.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution0133Test {

    @Test
    void cloneGraph() {
        Node node1 = new Node(1);
        Node node2 = new Node(2,
                new Node(4),
                new Node(5));
        Node node3 = new Node(3,
                new Node(6),
                new Node(7));
        Node node4 = new Node(4,
                new Node(8),
                new Node(9));
        Node node5 = new Node(5,
                new Node(10),
                new Node(11));
        Node node6 = new Node(6,
                new Node(12),
                new Node(13));
        Node node7 = new Node(7,
                new Node(14),
                new Node(15));
        Node node8 = new Node(8,
                new Node(16),
                new Node(17));
        Node node9 = new Node(9,
                new Node(18),
                new Node(19));
        Node node10 = new Node(10,
                new Node(20),
                new Node(21));
        Node node11 = new Node(11,
                new Node(22),
                new Node(23));
        Node node12 = new Node(12,
                new Node(24),
                new Node(25));
        Node node13 = new Node(13,
                new Node(26),
                new Node(27));
        Node node14 = new Node(14,
                new Node(28),
                new Node(29));
        Node node15 = new Node(15,
                new Node(30),
                new Node(31));

        node1.neighbors.add(node2);
        node1.neighbors.add(node3);
        node1.neighbors.add(node4);
        node1.neighbors.add(node5);
        node1.neighbors.add(node6);
        node1.neighbors.add(node7);
        node1.neighbors.add(node8);
        node1.neighbors.add(node9);
        node1.neighbors.add(node10);
        node1.neighbors.add(node11);
        node1.neighbors.add(node12);
        node1.neighbors.add(node13);
        node1.neighbors.add(node14);
        node1.neighbors.add(node15);

        Node clonedNode = new Solution0133().cloneGraph(node1);

        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }

}