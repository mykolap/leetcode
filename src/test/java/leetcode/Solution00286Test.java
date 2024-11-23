package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00286Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void wallsAndGates(String roomsStr, String expectedStr) {
        int[][] room = ArrayUtils.stringToInt2DArray(roomsStr);
        new Solution00286().wallsAndGates(room);
        assertThat(ArrayUtils.int2DArrayToString(room))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(Arguments.of("[[2147483647,-1,0,2147483647],[2147483647,2147483647,2147483647,-1],[2147483647,-1,2147483647,-1],[0,-1,2147483647,2147483647]]",
                        "[[3,-1,0,1],[2,2,1,-1],[1,-1,2,-1],[0,-1,3,4]]"),
                Arguments.of("[[2147483647,0,2147483647],[2147483647,2147483647,2147483647],[2147483647,-1,2147483647]]",
                        "[[1,0,1],[2,1,2],[3,-1,3]]")
        );
    }

}