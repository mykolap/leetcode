package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution00678Test {

    @ParameterizedTest
    @MethodSource("casesProvider")
    void checkValidString(String s, boolean expected) {
        boolean result = new Solution00678().checkValidString(s);
        assertEquals(expected, result);
    }

    private static Stream<Arguments> casesProvider() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("(*)", true),
                Arguments.of("(*))", true),
                Arguments.of("(*()", true),
                Arguments.of("(((((*)))**", true),
                Arguments.of("*", true),
                Arguments.of("(**(*()**()**((**(*)", true),
                Arguments.of("((*)(*))()*(*)****((*(*)())*()((()**(**)", true),
                Arguments.of(")(*()(**(*)())*))())())*)()()*(((*)()))(**()*)**(*", false),
                Arguments.of(")))(*)**)))*)))))*)*(((()(((*())(***)**(**((()))()((*((()(((", false),
                Arguments.of("()))))**)(()*()**)))()*)()())*(*)())**()*)))(**())))()**))*)*()**((*(*", false),
                Arguments.of("*(*)(*))((*)*)))(*)())*())()(()*)*)****)())(()()*(*(*())()((())))*()****)(*(()))((*()*(**(*()*)*()", true)
        );
    }

}