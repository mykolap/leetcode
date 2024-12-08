package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02054Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxTwoEvents(String eventsStr, int expected) {
        int[][] events = ArrayUtils.stringToInt2DArray(eventsStr);
        int actual = new Solution02054().maxTwoEvents(events);
        assertEquals(expected, actual);
    }

    /*
    Example 1:


Input: events = [[1,3,2],[4,5,2],[2,4,3]]
Output: 4
Explanation: Choose the green events, 0 and 1 for a sum of 2 + 2 = 4.
Example 2:

Example 1 Diagram
Input: events = [[1,3,2],[4,5,2],[1,5,5]]
Output: 5
Explanation: Choose event 2 for a sum of 5.
Example 3:


Input: events = [[1,5,3],[1,5,1],[6,6,5]]
Output: 8
Explanation: Choose events 0 and 2 for a sum of 3 + 5 = 8.

     */
    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,3,2],[4,5,2],[2,4,3]]", 4),
                Arguments.of("[[1,3,2],[4,5,2],[1,5,5]]", 5),
                Arguments.of("[[1,5,3],[1,5,1],[6,6,5]]", 8)
        );
    }

}