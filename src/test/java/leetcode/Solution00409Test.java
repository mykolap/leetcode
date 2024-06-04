package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00409Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void longestPalindrome(String s, int expected) {
        int actual = new Solution00409().longestPalindrome(s);
        assertThat(actual).isEqualTo(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("abccccdd", 7),
                Arguments.of("a", 1)
        );
    }

}