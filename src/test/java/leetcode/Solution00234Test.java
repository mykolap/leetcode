package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00234Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isPalindrome(ListNode head, boolean expected) {
        boolean result = new Solution00234().isPalindrome(head);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void isPalindromeStack(ListNode head, boolean expected) {
        boolean result = new Solution00234().isPalindromeStack(head);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(ListNode.of(1, 2, 2, 1), true),
                Arguments.of(ListNode.of(1, 2), false),
                Arguments.of(ListNode.of(1, 2, 1), true)
        );
    }

}