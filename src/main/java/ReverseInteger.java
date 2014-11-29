import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by CH3CHO on 11/28/2014.
 */
public class ReverseInteger {

    public int reverse(int x) {
        List<Integer> digits = new ArrayList<Integer>();
        boolean negative = x < 0;
        x = Math.abs(x);
        do {
            digits.add(x % 10);
            x /= 10;
        } while (x != 0);

        long result = 0;
        for (int i = digits.size() - 1, time = 1; i >= 0; --i, time *= 10) {
            long num = (long)digits.get(i) * time;
            result += num;
        }
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final ReverseInteger SOLUTION = new ReverseInteger();

        private final int number, expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {123, 321},
                    {-123, -321},
                    {0, 0},
                    {1, 1},
                    {10, 1},
                    {1000000003, 0},
                    {1534236469, 0},
                    {-2147483648, 0}
            });
        }

        public Tests(int number, int expectedResult) {
            this.number = number;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            int result = SOLUTION.reverse(number);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
