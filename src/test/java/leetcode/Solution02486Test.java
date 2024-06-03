package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution02486Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void appendCharacters(String s, String t, int expected) {
        int actual = new Solution02486().appendCharacters(s, t);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("coaching", "coding", 4),
                Arguments.of("abcde", "a", 0),
                Arguments.of("z", "abcde", 5)
        );
    }
}