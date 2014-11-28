import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by yqdong on 2014/11/25.
 */
@RunWith(Parameterized.class)
public class ReverseIntegerTest {

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

    public ReverseIntegerTest(int number, int expectedResult) {
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        int result = SOLUTION.reverse(number);
        Assert.assertEquals(expectedResult, result);
    }
}