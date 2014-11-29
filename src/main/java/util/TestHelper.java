package util;

import model.ListNode;
import model.TreeNode;
import org.junit.Assert;

import java.util.*;

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
            Assert.assertEquals(expected.val, actual.val);
            actual = actual.next;
            expected = expected.next;
        }
        Assert.assertTrue(expected == null && actual == null);
    }

    public static TreeNode buildTree(Integer... values) {
        return buildTreeNode(values, 0);
    }

    private static TreeNode buildTreeNode(Integer[] values, int index) {
        if (index < 0 || index >= values.length) {
            return null;
        }
        Integer value = values[index];
        if (value == null) {
            return null;
        }
        TreeNode node = new TreeNode(value);
        node.left = buildTreeNode(values, 2 * index + 1);
        node.right = buildTreeNode(values, 2 * index + 2);
        return node;
    }

    public static <T> List<List<T>> buildNestedList(T[][] values) {
        List<List<T>> result = new ArrayList<List<T>>();
        for (T[] array : values) {
            result.add(Arrays.asList(array));
        }
        return result;
    }
}
