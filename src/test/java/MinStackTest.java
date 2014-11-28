import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by CH3CHO on 11/28/2014.
 */
public class MinStackTest {

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
