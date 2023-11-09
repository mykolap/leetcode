package leetcode.encodeAndDecodeStrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SolutionTest {

    @ParameterizedTest
    @CsvSource({
            "Hello, World",
            "word, word;test"
    })
    void testEncodeAndDecode(String str1, String str2) {
        String[] strs = {str1, str2};

        Solution.Codec codec = new Solution().new Codec();
        String encoded = codec.encode(strs);
        String[] decoded = codec.decode(encoded);

        assertArrayEquals(strs, decoded);
    }

}