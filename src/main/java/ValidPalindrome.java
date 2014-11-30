import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://oj.leetcode.com/problems/valid-palindrome/
 *
 * Created by CH3CHO on 11/30/2014.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ) {
            char ch1 = s.charAt(i), ch2 = s.charAt(j);
            if (!Character.isAlphabetic(ch1) && !Character.isDigit(ch1)) {
                ++i;
                continue;
            }
            if (!Character.isAlphabetic(ch2) && !Character.isDigit(ch2)) {
                --j;
                continue;
            }
            if (Character.toLowerCase(ch1) != Character.toLowerCase(ch2)) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final ValidPalindrome SOLUTION = new ValidPalindrome();

        private final String input;
        private final boolean expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {"A man, a plan, a canal: Panama", true},
                            {"race a car", false},
                            {"1a2", false},
                            {"123321", true},
                            {"", true}
                    }
            );
        }

        public Tests(String input, boolean expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            boolean result = SOLUTION.isPalindrome(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
