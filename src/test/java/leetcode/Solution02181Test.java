package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02181Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void mergeNodes(String headStr, String expectedStr) {
        ListNode head = ListNode.of(headStr);
        ListNode actual = new Solution02181().mergeNodes(head);
        assertThat(actual).hasToString(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[0,3,1,0,4,5,2,0]", "[4,11]"),
                Arguments.of("[0,1,0,3,0,2,2,0]", "[1,3,4]")
        );
    }

}