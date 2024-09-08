package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00725Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void splitListToParts(String headStr, int k, String expectedStr) {
        ListNode head = ListNode.of(headStr);
        ListNode[] actual = new Solution00725().splitListToParts(head, k);
        assertThat(Arrays.toString(actual).replace(" ", ""))
                .hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[1,2,3]", 5, "[[1],[2],[3],null,null]"),
                Arguments.of("[1,2,3,4,5,6,7,8,9,10]", 3, "[[1,2,3,4],[5,6,7],[8,9,10]]"),
                Arguments.of("[1,2,3,4,5,6,7,8,9,10]", 7, "[[1,2],[3,4],[5,6],[7],[8],[9],[10]]")
        );
    }

}