package leetcode.redistributeCharactersToMakeAllStringsEqual;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution1897Test {

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
    void makeEqual(String[] words, boolean expected) {
        assertEquals(expected, new Solution1897().makeEqual(words));
    }
}