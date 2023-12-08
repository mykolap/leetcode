package leetcode.copyListWithRandomPointer;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    @Test
    void copyRandomList_test1() {
        Solution.Node node1 = new Solution.Node(7);
        Solution.Node node2 = new Solution.Node(13);
        Solution.Node node3 = new Solution.Node(11);
        Solution.Node node4 = new Solution.Node(10);
        Solution.Node node5 = new Solution.Node(1);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;

        assertThat(new Solution().copyRandomList(node1))
                .hasToString("[[7, null], [13, 7], [11, 1], [10, 11], [1, 7]]");

        assertThat(new Solution().copyRandomListInterweavingNodes(node1))
                .hasToString("[[7, null], [13, 7], [11, 1], [10, 11], [1, 7]]");
    }

    @Test
    void copyRandomList_test2() {
        Solution.Node node1 = new Solution.Node(1);
        Solution.Node node2 = new Solution.Node(2);
        node1.next = node2;
        node1.random = node1;
        node2.random = node1;

        assertThat(new Solution().copyRandomList(node1))
                .hasToString("[[1, 1], [2, 1]]");

        assertThat(new Solution().copyRandomListInterweavingNodes(node1))
                .hasToString("[[1, 1], [2, 1]]");
    }

}