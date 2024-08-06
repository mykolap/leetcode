package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution03014Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minimumPushes(String word, int expected) {
        int actual = new Solution03014().minimumPushes(word);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcde", 5),
                Arguments.of("xycdefghij", 12)
        );
    }

}