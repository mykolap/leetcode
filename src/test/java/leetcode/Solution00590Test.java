package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00590Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void postorder(Solution00590.Node root, String expected) {
        assertEquals(expected, new Solution00590().postorder(root).toString().replace(" ", ""));
    }

    private static Stream<Arguments> casesProvider() {
        Solution00590.Node node1 = new Solution00590().new Node(1);
        Solution00590.Node node2 = new Solution00590().new Node(2);
        Solution00590.Node node3 = new Solution00590().new Node(3);
        Solution00590.Node node4 = new Solution00590().new Node(4);
        Solution00590.Node node5 = new Solution00590().new Node(5);
        Solution00590.Node node6 = new Solution00590().new Node(6);
        node1.children = List.of(node3, node2, node4);
        node3.children = List.of(node5, node6);
        return Stream.of(Arguments.of(node1, "[5,6,3,2,4,1]"));
    }

}