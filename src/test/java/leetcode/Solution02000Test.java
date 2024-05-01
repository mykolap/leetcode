package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02000Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reversePrefix(String word, char ch, String expected) {
        String result = new Solution02000().reversePrefix(word, ch);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abcdef", 'd', "dcbaef"),
                Arguments.of("xyxzxe", 'z', "zxyxxe"),
                Arguments.of("abcd", 'z', "abcd")
        );
    }

}