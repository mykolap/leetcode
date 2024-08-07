package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00273Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberToWords(int num, String expected) {
        String actual = new Solution00273().numberToWords(num);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("casesProvider")
    void numberToWordsStructured(int num, String expected) {
        String actual = new Solution00273().numberToWordsStructured(num);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of(123, "One Hundred Twenty Three"),
                Arguments.of(12_345, "Twelve Thousand Three Hundred Forty Five"),
                Arguments.of(1_234_567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"),
                Arguments.of(1_234_567_890, "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety"),
                Arguments.of(0, "Zero"),
                Arguments.of(1_000_000_000, "One Billion"),
                Arguments.of(10, "Ten"),
                Arguments.of(1_010, "One Thousand Ten"),
                Arguments.of(1_000_010, "One Million Ten")
        );
    }

}