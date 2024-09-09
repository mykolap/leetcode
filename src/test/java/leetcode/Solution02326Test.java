package leetcode;

import leetcode.common.ListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02326Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void spiralMatrix(int m, int n, String headStr, String expectedStr) {
        ListNode head = ListNode.of(headStr);
        int[][] result = new Solution02326().spiralMatrix(m, n, head);
        assertThat(Arrays.deepToString(result).replace(" ", ""))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(3, 5, "[3,0,2,6,8,1,7,9,4,2,5,5,0]", "[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]"),
                Arguments.of(1, 4, "[0,1,2]", "[[0,1,2,-1]]")
        );
    }

}