package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution02707Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minExtraChar(String s, String dictionaryStr, int expected) {
        String[] dictionary = ArrayUtils.stringToStringArray(dictionaryStr);
        int actual = new Solution02707().minExtraChar(s, dictionary);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("leetscode", "[\"leet\",\"code\",\"leetcode\"]", 1),
                Arguments.of("sayhelloworld", "[\"hello\",\"world\"]", 3),
                Arguments.of("dwmodizxvvbosxxw", "[\"ox\",\"lb\",\"diz\",\"gu\",\"v\",\"ksv\",\"o\",\"nuq\",\"r\",\"txhe\",\"e\",\"wmo\",\"cehy\",\"tskz\",\"ds\",\"kzbu\"]", 7)
        );
    }

}