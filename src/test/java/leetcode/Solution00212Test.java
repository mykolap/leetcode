package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00212Test {

    static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(new char[][]{{'o', 'a', 'a', 'n'},
                                {'e', 't', 'a', 'e'},
                                {'i', 'h', 'k', 'r'},
                                {'i', 'f', 'l', 'v'}},
                        new String[]{"oath", "pea", "eat", "rain"},
                        new String[]{"oath", "eat"}),
                Arguments.of(new char[][]{{'a', 'b'},
                                {'c', 'd'}},
                        new String[]{"abcb"},
                        new String[]{})
        );
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void findWords(char[][] board, String[] words, String[] expected) {
        String[] actual = new Solution00212().findWords(board, words).toArray(new String[0]);
        assertArrayEquals(expected, actual);
    }

}