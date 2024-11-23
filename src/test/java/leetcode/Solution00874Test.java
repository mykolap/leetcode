package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00874Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void robotSim(String commandsStr, String obstaclesStr, int expected) {
        int[] commands = ArrayUtils.stringToIntArray(commandsStr);
        int[][] obstacles = ArrayUtils.stringToInt2DArray(obstaclesStr);
        int result = new Solution00874().robotSim(commands, obstacles);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[4,-1,3]", "[]", 25),
                Arguments.of("[4,-1,4,-2,4]", "[[2,4]]", 65),
                Arguments.of("[6,-1,-1,6]", "[]", 36)
        );
    }

}