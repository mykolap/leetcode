package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01897Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(
                        new String[]{"abc", "aabc", "bc"},
                        true
                ),
                Arguments.of(
                        new String[]{"ab", "a"},
                        false
                ),
                Arguments.of(
                        new String[]{"a"},
                        true
                ),
                Arguments.of(
                        new String[]{"aa", "bb", "cc", "dd"},
                        false
                ),
                Arguments.of(
                        new String[]{"a", "b"},
                        false
                )
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void makeEqualMap(String[] words, boolean expected) {
        Assertions.assertEquals(expected, new Solution01897().makeEqualMap(words));
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void makeEqualArray(String[] words, boolean expected) {
        assertEquals(expected, new Solution01897().makeEqualArray(words));
    }

}