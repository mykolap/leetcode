package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00092Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseBetween(ListNode head, int left, int right, String expected) {
        var result = new Solution00092().reverseBetween(head, left, right);
        assertThat(result)
                .hasToString(expected);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 3, 4, 5), 2, 4, "[1,4,3,2,5]"),
                Arguments.of(ListNode.of(5), 1, 1, "[5]"),
                Arguments.of(ListNode.of(3, 5), 1, 2, "[5,3]")
        );
    }

}