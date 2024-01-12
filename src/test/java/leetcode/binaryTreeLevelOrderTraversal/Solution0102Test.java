package leetcode.binaryTreeLevelOrderTraversal;

import leetcode.common.TreeNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution0102Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        TreeNode.of(3, 9, 20, null, null, 15, 7),
                        List.of(List.of(3), List.of(9, 20), List.of(15, 7))
                ),
                Arguments.of(
                        TreeNode.of(1),
                        List.of(List.of(1))
                ),
                Arguments.of(
                        TreeNode.of(),
                        List.of()
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void levelOrder(TreeNode head, List<List<Integer>> expected) {
        assertThat(new Solution0102().levelOrder(head))
                .containsExactlyElementsOf(expected);
    }

}