package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02812Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumSafenessFactor(String gridStr, int expected) {
        final List<List<Integer>> stringTo2DList = ArrayUtils.stringToListOfLists(gridStr);
        int result = new Solution02812().maximumSafenessFactor(stringTo2DList);
        assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumSafenessFactorAlternative(String gridStr, int expected) {
        final List<List<Integer>> stringTo2DList = ArrayUtils.stringToListOfLists(gridStr);
        int result = new Solution02812().maximumSafenessFactorAlternative(stringTo2DList);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,0,0],[0,0,0],[0,0,1]]", 0),
                Arguments.of("[[0,0,1],[0,0,0],[0,0,0]]", 2),
                Arguments.of("[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]", 2)
        );
    }

}