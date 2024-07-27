package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02976Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumCost(String source, String target, String original, String changed, String cost, long expected) {
        char[] originalChars = original.toCharArray();
        char[] changedChars = changed.toCharArray();
        int[] costInts = ArrayUtils.stringToIntArray(cost);

        long result = new Solution02976().minimumCost(source, target, originalChars, changedChars, costInts);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcd", "acbe",
                        "abcced", "bcbebe",
                        "[2,5,5,1,2,20]", 28),
                Arguments.of("aaaa", "bbbb",
                        "ac", "cb",
                        "[1,2]", 12),
                Arguments.of("abcd", "abce",
                        "a", "e",
                        "[10000]", -1)
        );
    }
}