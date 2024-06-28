package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02285Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumImportance(int n, String roadsStr, long expected) {
        int[][] roads = ArrayUtils.stringTo2DIntArray(roadsStr);
        assertEquals(expected, new Solution02285().maximumImportance(n, roads));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(5, "[[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]", 43),
                Arguments.of(5, "[[0,3],[2,4],[1,3]]", 20)
        );
    }

}