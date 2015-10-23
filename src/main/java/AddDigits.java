import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://leetcode.com/problems/add-digits/
 * <p>
 * Created by yqdong on 2015/10/23.
 */
public class AddDigits {

    public int addDigits(int num) {
//        return addDigitsTraditionalWay(num);
        return addDigitsDigitalRootWay(num);
    }

    private int addDigitsTraditionalWay(int num) {

        int result = 0;
        do {
            result += num % 10;
            num /= 10;
        } while (num != 0);
        return addDigits(result);
    }

    private int addDigitsDigitalRootWay(int num) {
        if (num < 0) {
            num = -num;
        }
        if (num < 10) {
            return num;
        }
        int root = num % 9;
        return root == 0 ? 9 : root;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final AddDigits SOLUTION = new AddDigits();

        private final int num;
        private final int expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {0, 0},
                    {38, 2},
                    {11, 2},
                    {9, 9},
                    {36, 9},
                    {15, 6},
                    {198, 9},
                    {1234, 1},
            });
        }

        public Tests(int num, int expectedResult) {
            this.num = num;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            int result = SOLUTION.addDigits(num);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
