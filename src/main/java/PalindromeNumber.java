import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by CH3CHO on 11/29/2014.
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long frontDiv = 1;
        for (; x / frontDiv != 0; frontDiv *= 10) {
        }
        frontDiv /= 10;

        for (int backDiv = 10; backDiv <= frontDiv; backDiv *= 10, frontDiv /= 10) {
            long front = x / frontDiv % 10;
            long back = x % backDiv / (backDiv / 10);
            if (front != back) {
                return false;
            }
        }
        return true;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final PalindromeNumber SOLUTION = new PalindromeNumber();

        private final int input;
        private final boolean expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {12321, true},
                            {12341, false},
                            {123441, false},
                            {123321, true},
                            {1000000001, true},
                            {-1, false},
                            {1, true},
                    }
            );
        }

        public Tests(int input, boolean expectedResult) {
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
