import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by yqdong on 2014/11/25.
 */
public final class TestHelper {

    private static final Map<Integer, ListNode> _internNodes = new HashMap<Integer, ListNode>();

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

    public static ListNode buildInternList(int... numbers) {
        ListNode rootNode = null, currentNode = null;
        for (int number : numbers) {
            ListNode node = getInternNode(number);
            if (currentNode == null) {
                rootNode = node;
            } else {
                currentNode.next = node;
            }
            currentNode = node;
        }
        currentNode.next = null;
        return rootNode;
    }

    public static ListNode getInternNode(int number) {
        ListNode node = _internNodes.get(number);
        if (node == null) {
            node = new ListNode(number);
            _internNodes.put(number, node);
        }
        return node;
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
