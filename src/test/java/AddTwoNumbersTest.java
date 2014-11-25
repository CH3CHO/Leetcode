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
                {buildNumberList(2, 4, 3), buildNumberList(5, 6, 4), buildNumberList(7, 0, 8)},
                {buildNumberList(2, 4), buildNumberList(5, 6, 4), buildNumberList(7, 0, 5)},
                {buildNumberList(2, 4), buildNumberList(5, 6, 4, 1, 2), buildNumberList(7, 0, 5, 1, 2)},
                {buildNumberList(5), buildNumberList(5), buildNumberList(0, 1)},
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
        ListNode resultToCompare = expectedResult;
        while (result != null && resultToCompare != null) {
            assertEquals(resultToCompare.val, result.val);
            result = result.next;
            resultToCompare = resultToCompare.next;
        }
        assertTrue(result == null && resultToCompare == null);
    }

    private static ListNode buildNumberList(int... numbers) {
        ListNode rootNode = null, currentNode = null;
        for (int number : numbers) {
            ListNode node = new ListNode(number);
            if (currentNode == null) {
                rootNode = node;
            } else {
                currentNode.next = node;
            }
            currentNode = node;
        }
        return rootNode;
    }
}
