package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00648Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void replaceWords(String sentence, List<String> dictionary, String expected) {
        var solution = new Solution00648();
        var result = solution.replaceWords(dictionary, sentence);
        assertEquals(expected, result);
    }

    private static List<Arguments> casesProvider() {
        return List.of(
                Arguments.of("the cattle was rattled by the battery", List.of("cat", "bat", "rat"), "the cat was rat by the bat"),
                Arguments.of("aadsfasf absbs bbab cadsfafs", List.of("a", "b", "c"), "a a b c"),
                Arguments.of("a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa", List.of("a", "aa", "aaa", "aaaa"), "a a a a a a a a bbb baba a")
        );
    }

}