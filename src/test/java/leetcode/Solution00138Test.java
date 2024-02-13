package leetcode;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00138Test {

    @Test
    void copyRandomList_test1() {
        Solution00138.Node node1 = new Solution00138.Node(7);
        Solution00138.Node node2 = new Solution00138.Node(13);
        Solution00138.Node node3 = new Solution00138.Node(11);
        Solution00138.Node node4 = new Solution00138.Node(10);
        Solution00138.Node node5 = new Solution00138.Node(1);
        node1.next = node2;
        node2.next = node3;
        node2.random = node1;
        node3.next = node4;
        node3.random = node5;
        node4.next = node5;
        node4.random = node3;
        node5.random = node1;

        assertThat(new Solution00138().copyRandomList(node1))
                .hasToString("[[7, null], [13, 7], [11, 1], [10, 11], [1, 7]]");

        assertThat(new Solution00138().copyRandomListInterweavingNodes(node1))
                .hasToString("[[7, null], [13, 7], [11, 1], [10, 11], [1, 7]]");
    }

    @Test
    void copyRandomList_test2() {
        Solution00138.Node node1 = new Solution00138.Node(1);
        Solution00138.Node node2 = new Solution00138.Node(2);
        node1.next = node2;
        node1.random = node1;
        node2.random = node1;

        assertThat(new Solution00138().copyRandomList(node1))
                .hasToString("[[1, 1], [2, 1]]");

        assertThat(new Solution00138().copyRandomListInterweavingNodes(node1))
                .hasToString("[[1, 1], [2, 1]]");
    }

}