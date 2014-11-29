import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://oj.leetcode.com/problems/string-to-integer-atoi/
 * <p/>
 * Created by CH3CHO on 11/29/2014.
 */
public class StringToInteger {

    public int atoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        boolean hasSymbol = false;
        char firstChar = str.charAt(0);
        boolean negative = false;
        if (firstChar == '+') {
            hasSymbol = true;
        } else if (firstChar == '-') {
            hasSymbol = true;
            negative = true;
        }
        int result = 0;
        int limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
        int multiLimit = limit / 10;
        for (int i = hasSymbol ? 1 : 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            int val = ch - '0';
            if (result < multiLimit) {
                result = limit;
                break;
            }
            result *= 10;
            if (result < limit + val) {
                result = limit;
                break;
            }
            result -= val;
        }
        return negative ? result : -result;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final StringToInteger SOLUTION = new StringToInteger();

        private final String input;
        private final int expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {"123", 123},
                            {"1a23", 1},
                            {"  -12a23", -12},
                            {"    010  ", 10},
                            {"+123", 123},
                            {"100001", 100001},
                            {String.valueOf(Integer.MAX_VALUE), Integer.MAX_VALUE},
                            {String.valueOf(Integer.MIN_VALUE), Integer.MIN_VALUE},
                            {"2147483648", Integer.MAX_VALUE},
                            {"-2147483649", Integer.MIN_VALUE},
                            {"9876543210123", Integer.MAX_VALUE},
                            {"", 0},
                            {null, 0},
                    }
            );
        }

        public Tests(String input, int expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            int result = SOLUTION.atoi(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
