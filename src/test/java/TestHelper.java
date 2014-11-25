import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yqdong on 2014/11/25.
 */
public final class TestHelper {

    private TestHelper() {
    }

    public static ListNode buildList(int... numbers) {
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

    public static void checkLists(ListNode expected, ListNode actual) {
        while (expected != null && actual != null) {
            assertEquals(expected.val, actual.val);
            actual = actual.next;
            expected = expected.next;
        }
        assertTrue(expected == null && actual == null);
    }
}
