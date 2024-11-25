package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00773Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void slidingPuzzle(String boardStr, int expected) {
        int[][] board = ArrayUtils.stringToInt2DArray(boardStr);
        int result = new Solution00773().slidingPuzzle(board);
        assertEquals(expected, result);
    }

    /*
    Example 1:


Input: board = [[1,2,3],[4,0,5]]
Output: 1
Explanation: Swap the 0 and the 5 in one move.
Example 2:


Input: board = [[1,2,3],[5,4,0]]
Output: -1
Explanation: No number of moves will make the board solved.
Example 3:


Input: board = [[4,1,2],[5,0,3]]
Output: 5
Explanation: 5 is the smallest number of moves that solves the board.
An example path:
After move 0: [[4,1,2],[5,0,3]]
After move 1: [[4,1,2],[0,5,3]]
After move 2: [[0,1,2],[4,5,3]]
After move 3: [[1,0,2],[4,5,3]]
After move 4: [[1,2,0],[4,5,3]]
After move 5: [[1,2,3],[4,5,0]]



     */

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2,3],[4,0,5]]", 1),
                Arguments.of("[[1,2,3],[5,4,0]]", -1),
                Arguments.of("[[4,1,2],[5,0,3]]", 5)
        );
    }

}