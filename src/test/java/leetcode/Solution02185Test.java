package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02185Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(String wordsStr, String pref, int expected) {
        String[] words = ArrayUtils.stringToStringArray(wordsStr);
        int result = new Solution02185().prefixCount(words, pref);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"pay\",\"attention\",\"practice\",\"attend\"]", "at", 2),
                Arguments.of("[\"leetcode\",\"win\",\"loops\",\"success\"]", "code", 0)
        );
    }

}