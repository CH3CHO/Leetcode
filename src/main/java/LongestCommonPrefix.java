import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://oj.leetcode.com/problems/longest-common-prefix/
 * <p/>
 * Created by CH3CHO on 11/30/2014.
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String firstStr = strs[0];
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < firstStr.length(); ++i) {
            char ch = firstStr.charAt(i);
            for (String str : strs) {
                if (i >= str.length()) {
                    return prefix.toString();
                }
                char strCh = str.charAt(i);
                if (strCh != ch) {
                    return prefix.toString();
                }
            }
            prefix.append(ch);
        }
        return prefix.toString();
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final LongestCommonPrefix SOLUTION = new LongestCommonPrefix();

        private final String[] input;
        private final String expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {new String[0], ""},
                            {new String[]{"abc", "abcd", "abcde"}, "abc"},
                            {new String[]{"a", "b", "c"}, ""},
                    }
            );
        }

        public Tests(String[] input, String expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            String result = SOLUTION.longestCommonPrefix(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
