package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02559Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void countGoodStrings(String wordsStr, String queriesStr, String expectedStr) {
        String[] words = ArrayUtils.stringToStringArray(wordsStr);
        int[][] queries = ArrayUtils.stringToInt2DArray(queriesStr);
        int[] result = new Solution02559().vowelStrings(words, queries);
        assertThat(ArrayUtils.intArrayToString(result))
                .isEqualTo(expectedStr);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"aba\",\"bcb\",\"ece\",\"aa\",\"e\"]", "[[0,2],[1,4],[1,1]]", "[2,3,0]"),
                Arguments.of("[\"a\",\"e\",\"i\"]", "[[0,2],[0,1],[2,2]]", "[3,2,1]")
        );
    }

}