package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02070Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maximumBeauty(String itemsStr, String queriesStr, String expectedStr) {
        int[][] items = ArrayUtils.stringTo2DIntArray(itemsStr);
        int[] queries = ArrayUtils.stringToIntArray(queriesStr);
        int[] result = new Solution02070().maximumBeauty(items, queries);
        assertThat(ArrayUtils.intArrayToString(result)).isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[[1,2],[3,2],[2,4],[5,6],[3,5]]", "[1,2,3,4,5,6]", "[2,4,5,5,6,6]"),
                Arguments.of("[[1,2],[1,2],[1,3],[1,4]]", "[1]", "[4]"),
                Arguments.of("[[10,1000]]", "[5]", "[0]")
        );
    }

}