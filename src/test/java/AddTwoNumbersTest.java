import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yqdong on 2014/11/25.
 */
@RunWith(Parameterized.class)
public class AddTwoNumbersTest {

    private static final AddTwoNumbers SOLUTION = new AddTwoNumbers();

    private final ListNode l1, l2, expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TestHelper.buildList(2, 4, 3), TestHelper.buildList(5, 6, 4), TestHelper.buildList(7, 0, 8)},
                {TestHelper.buildList(2, 4), TestHelper.buildList(5, 6, 4), TestHelper.buildList(7, 0, 5)},
                {TestHelper.buildList(2, 4), TestHelper.buildList(5, 6, 4, 1, 2), TestHelper.buildList(7, 0, 5, 1, 2)},
                {TestHelper.buildList(5), TestHelper.buildList(5), TestHelper.buildList(0, 1)},
        });
    }

    public AddTwoNumbersTest(ListNode l1, ListNode l2,
                             ListNode expectedResult) {
        this.l1 = l1;
        this.l2 = l2;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        ListNode result = SOLUTION.addTwoNumbers(l1, l2);
        TestHelper.checkLists(expectedResult, result);
    }
}
