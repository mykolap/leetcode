package leetcode.cloneGraph;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void cloneGraph() {
        Solution.Node node1 = new Solution.Node(1);
        Solution.Node node2 = new Solution.Node(2,
                new Solution.Node(4),
                new Solution.Node(5));
        Solution.Node node3 = new Solution.Node(3,
                new Solution.Node(6),
                new Solution.Node(7));
        Solution.Node node4 = new Solution.Node(4,
                new Solution.Node(8),
                new Solution.Node(9));
        Solution.Node node5 = new Solution.Node(5,
                new Solution.Node(10),
                new Solution.Node(11));
        Solution.Node node6 = new Solution.Node(6,
                new Solution.Node(12),
                new Solution.Node(13));
        Solution.Node node7 = new Solution.Node(7,
                new Solution.Node(14),
                new Solution.Node(15));
        Solution.Node node8 = new Solution.Node(8,
                new Solution.Node(16),
                new Solution.Node(17));
        Solution.Node node9 = new Solution.Node(9,
                new Solution.Node(18),
                new Solution.Node(19));
        Solution.Node node10 = new Solution.Node(10,
                new Solution.Node(20),
                new Solution.Node(21));
        Solution.Node node11 = new Solution.Node(11,
                new Solution.Node(22),
                new Solution.Node(23));
        Solution.Node node12 = new Solution.Node(12,
                new Solution.Node(24),
                new Solution.Node(25));
        Solution.Node node13 = new Solution.Node(13,
                new Solution.Node(26),
                new Solution.Node(27));
        Solution.Node node14 = new Solution.Node(14,
                new Solution.Node(28),
                new Solution.Node(29));
        Solution.Node node15 = new Solution.Node(15,
                new Solution.Node(30),
                new Solution.Node(31));

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

        Solution.Node clonedNode = new Solution().cloneGraph(node1);

        assertEquals(node1.val, clonedNode.val);
        assertEquals(node1.neighbors.size(), clonedNode.neighbors.size());
    }

}