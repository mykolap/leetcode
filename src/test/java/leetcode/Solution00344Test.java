package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00344Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void reverseString(String s, String expected) {
        char[] sourceArray = s.toCharArray();
        new Solution00344().reverseString(sourceArray);

        assertThat(String.valueOf(sourceArray))
                .isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("a", "a"),
                Arguments.of("ab", "ba"),
                Arguments.of("abc", "cba"),
                Arguments.of("abcd", "dcba"),
                Arguments.of("hello", "olleh"),
                Arguments.of("hello", "olleh"),
                Arguments.of("Hannah", "hannaH")
        );
    }

}