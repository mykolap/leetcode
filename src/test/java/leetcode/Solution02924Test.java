package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02924Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findChampion(int expected, int n, String edgesStr) {
        int[][] edges = ArrayUtils.stringToInt2DArray(edgesStr);
        assertEquals(expected, new Solution02924().findChampion(n, edges));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(0, 3, "[[0,1],[1,2]]"),
                Arguments.of(-1, 4, "[[0,2],[1,3],[1,2]]")
        );
    }

}