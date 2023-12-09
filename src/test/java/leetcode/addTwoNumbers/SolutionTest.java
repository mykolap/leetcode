package leetcode.addTwoNumbers;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    static Stream<Arguments> getAddTwoNumbersArgs() {
        return Stream.of(
                Arguments.of(ListNode.fromVarArgArray(2, 4, 3), ListNode.fromVarArgArray(5, 6, 4), "[7, 0, 8]"),
                Arguments.of(ListNode.fromVarArgArray(0), ListNode.fromVarArgArray(0), "[0]"),
                Arguments.of(ListNode.fromVarArgArray(9, 9, 9, 9, 9, 9, 9), ListNode.fromVarArgArray(9, 9, 9, 9), "[8, 9, 9, 9, 0, 0, 0, 1]")
        );
    }

    @ParameterizedTest
    @MethodSource("getAddTwoNumbersArgs")
    void addTwoNumbers(ListNode l1, ListNode l2, String expectedSum) {
        assertThat(new Solution().addTwoNumbers(l1, l2))
                .hasToString(expectedSum);
    }

}