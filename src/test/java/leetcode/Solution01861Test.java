package leetcode;

import leetcode.common.ArrayUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class Solution01861Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void rotateTheBox(String boxStr, String expectedStr) {
        char[][] box = ArrayUtils.stringToChar2DArray(boxStr);
        System.out.println(Arrays.deepToString(box));
        char[][] actual = new Solution01861().rotateTheBox(box);
        assertThat(ArrayUtils.char2DArrayToString(actual))
                .isEqualTo(expectedStr.replaceAll("\\s", ""));
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("""
                                [["#",".","#"]]""",
                        """
                                [["."],
                                 ["#"],
                                 ["#"]]"""),
                Arguments.of("""
                                [["#",".","*","."],
                                 ["#","#","*","."]]""",
                        """
                                [["#","."],
                                 ["#","#"],
                                 ["*","*"],
                                 [".","."]]"""),
                Arguments.of("""
                                [["#","#","*",".","*","."],
                                 ["#","#","#","*",".","."],
                                 ["#","#","#",".","#","."]]""",
                        """
                                [[".","#","#"],
                                 [".","#","#"],
                                 ["#","#","*"],
                                 ["#","*","."],
                                 ["#",".","*"],
                                 ["#",".","."]]
                                """)
        );
    }

}
