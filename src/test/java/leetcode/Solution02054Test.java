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

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,3,2],[4,5,2],[2,4,3]]", 4),
                Arguments.of("[[1,3,2],[4,5,2],[1,5,5]]", 5),
                Arguments.of("[[1,5,3],[1,5,1],[6,6,5]]", 8)
        );
    }

}