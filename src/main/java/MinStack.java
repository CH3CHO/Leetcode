import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by CH3CHO on 11/28/2014.
 */
public class MinStack {

    private int[] values = new int[4];
    private int[] mins = new int[4];
    private int count;

    public void push(int x) {
        ensureCapacity();
        values[count] = x;
        mins[count] = count != 0 ? Math.min(mins[count - 1], x) : x;
        ++count;
    }

    public void pop() {
        --count;
    }

    public int top() {
        return count != 0 ? values[count - 1] : 0;
    }

    public int getMin() {
        return count != 0 ? mins[count - 1] : 0;
    }

    private void ensureCapacity() {
        if (count < values.length) {
            return;
        }
        values = Arrays.copyOf(values, count * 2);
        mins = Arrays.copyOf(mins, count * 2);
    }

    public static class Tests {

        private MinStack stack;

        @Before
        public void before() {
            stack = new MinStack();
        }

        @Test
        public void test() {
            stack.push(5);
            assertValues(5, 5);
            stack.push(3);
            stack.push(4);
            assertValues(4, 3);
            stack.pop();
            assertValues(3, 3);

            stack.push(10);
            stack.push(1);
            stack.push(100);
            stack.push(500);
            assertValues(500, 1);
        }

        private void assertValues(int top, int min) {
            Assert.assertEquals(top, stack.top());
            Assert.assertEquals(min, stack.getMin());
        }
    }

}
