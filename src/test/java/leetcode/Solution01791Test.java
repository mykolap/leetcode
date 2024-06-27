package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01791Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findCenter(String edgesStr, int expected) {
        int[][] edges = ArrayUtils.stringTo2DIntArray(edgesStr);
        assertEquals(expected, new Solution01791().findCenter(edges));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2],[2,3],[4,2]]", 2),
                Arguments.of("[[1,2],[5,1],[1,3],[1,4]]", 1)
        );
    }

}