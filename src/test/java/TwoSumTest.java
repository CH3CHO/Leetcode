import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by yqdong on 2014/11/25.
 */
@RunWith(Parameterized.class)
public class TwoSumTest {

    private static final TwoSum SOLUTION = new TwoSum();

    private final int[] numbers;
    private final int target;
    private final int[] expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}},
                {new int[]{11, 2, 14, 7, 15}, 9, new int[]{2, 4}}
        });
    }

    public TwoSumTest(int[] numbers, int target, int[] expectedResult) {
        this.numbers = numbers;
        this.target = target;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        int[] result = SOLUTION.twoSum(numbers, target);
        assertEquals(expectedResult.length, result.length);
        assertEquals(expectedResult[0], result[0]);
        assertEquals(expectedResult[1], result[1]);
    }
}
