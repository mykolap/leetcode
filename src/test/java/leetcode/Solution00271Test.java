package leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Solution00271Test {

    @ParameterizedTest
    @CsvSource({
            "Hello, World",
            "word, word;test"
    })
    void testEncodeAndDecode(String str1, String str2) {
        String[] strs = {str1, str2};

        Solution00271.Codec codec = new Solution00271().new Codec();
        String encoded = codec.encode(strs);
        String[] decoded = codec.decode(encoded);

        assertArrayEquals(strs, decoded);
    }

}