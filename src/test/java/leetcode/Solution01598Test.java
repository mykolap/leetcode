package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution01598Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void minOperations(String logsStr, int expected) {
        String[] logs = ArrayUtils.stringToStringArray(logsStr);
        int result = new Solution01598().minOperations(logs);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("[\"d1/\",\"d2/\",\"../\",\"d21/\",\"./\"]", 2),
                Arguments.of("[\"d1/\",\"d2/\",\"./\",\"d3/\",\"../\",\"d31/\"]", 3),
                Arguments.of("[\"d1/\",\"../\",\"../\",\"../\"]", 0)
        );
    }

}