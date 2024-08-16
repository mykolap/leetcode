package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00624Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxDistance(String arraysStr, int expected) {
        List<List<Integer>> arrays = ArrayUtils.stringToListOfLists(arraysStr);
        final int result = new Solution00624().maxDistance(arrays);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2,3],[4,5],[1,2,3]]", 4),
                Arguments.of("[[1],[1]]", 0),
                Arguments.of("[[-1,1],[-3,1,4],[-2,-1,0,2]]", 6)
        );
    }
}