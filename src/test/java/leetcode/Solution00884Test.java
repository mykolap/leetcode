package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution00884Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void uncommonFromSentences(String s1, String s2, String[] expected) {
        var actual = new Solution00884().uncommonFromSentences(s1, s2);
        assertThat(actual).containsExactlyInAnyOrder(expected);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("this apple is sweet", "this apple is sour", new String[]{"sweet", "sour"}),
                Arguments.of("apple apple", "banana", new String[]{"banana"})
        );
    }

}