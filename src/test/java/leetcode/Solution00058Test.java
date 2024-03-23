package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00058Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void lengthOfLastWord(String s, int expected) {
        int result = new Solution00058().lengthOfLastWord(s);
        assertEquals(expected, result);
    }

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("Hello World", 5),
                Arguments.of(" ", 0),
                Arguments.of("a ", 1),
                Arguments.of("   fly me   to   the moon  ", 4),
                Arguments.of("luffy is still joyboy", 6)
        );
    }

}