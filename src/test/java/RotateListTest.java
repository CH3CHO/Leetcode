import model.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by yqdong on 2014/11/25.
 */
@RunWith(Parameterized.class)
public class RotateListTest {

    private static final RotateList SOLUTION = new RotateList();

    private final ListNode list;
    private final int number;
    private final ListNode expectedResult;

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {TestHelper.buildList(), 0, TestHelper.buildList()},
                {TestHelper.buildList(), 1, TestHelper.buildList()},
                {TestHelper.buildList(1, 2, 3, 4, 5), 2, TestHelper.buildList(4, 5, 1, 2, 3)},
                {TestHelper.buildList(1), 1, TestHelper.buildList(1)},
                {TestHelper.buildList(2, 4, 3), 3, TestHelper.buildList(2, 4, 3)},
                {TestHelper.buildList(2, 4, 3), 4, TestHelper.buildList(3, 2, 4)},
        });
    }

    public RotateListTest(ListNode list, int number, ListNode expectedResult) {
        this.list = list;
        this.number = number;
        this.expectedResult = expectedResult;
    }

    @Test
    public void test() {
        ListNode result = SOLUTION.rotateRight(list, number);
        TestHelper.checkLists(expectedResult, result);
    }
}
