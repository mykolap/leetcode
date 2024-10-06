package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01813Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void areSentencesSimilar(String sentence1, String sentence2, boolean expected) {
        boolean result = new Solution01813().areSentencesSimilar(sentence1, sentence2);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("My name is Haley", "My Haley", true),
                Arguments.of("of", "A lot of words", false),
                Arguments.of("Eating right now", "Eating", true),
                Arguments.of("Luky", "Lucccky", false),
                Arguments.of("B", "ByI BMyQIqce", false),
                Arguments.of("H", "KkvJA P JdWksnH", false)
        );
    }

}