package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00959Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void regionsBySlashes(String gridStr, int expected) {
        String[] grid = ArrayUtils.stringToStringList(gridStr).toArray(new String[0]);
        int actual = new Solution00959().regionsBySlashes(grid);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\" /\",\"/ \"]", 2),
                Arguments.of("[\" /\",\"  \"]", 1),
                Arguments.of("[\"/\\\",\"\\/\"]", 5)
        );
    }

}