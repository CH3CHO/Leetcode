import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://leetcode.com/problems/nim-game/
 * <p>
 * Created by yqdong on 2015/10/23.
 */
public class NimGame {

    public boolean canWinNim(int n) {
        return (n & 3) != 0;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final NimGame SOLUTION = new NimGame();

        private final int n;
        private final boolean expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {4, false},
                    {5, true},
            });
        }

        public Tests(int n, boolean expectedResult) {
            this.n = n;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            boolean result = SOLUTION.canWinNim(n);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
