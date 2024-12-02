package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01455Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void maxAncestorDiff(String sentence, String searchWord, int expected) {
        int result = new Solution01455().isPrefixOfWord(sentence, searchWord);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("i love eating burger", "burg", 4),
                Arguments.of("this problem is an easy problem", "pro", 2),
                Arguments.of("i am tired", "you", -1)
        );
    }

}