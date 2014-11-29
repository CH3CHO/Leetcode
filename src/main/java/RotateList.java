import model.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by yqdong on 2014/11/25.
 */
public class RotateList {

    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        int count = 0;
        for (ListNode current = head; current != null; current = current.next, ++count) {
        }
        while (n != 0 && n >= count) {
            n -= count;
        }
        if (n == 0) {
            return head;
        }

        Deque<ListNode> nodeQueue = new LinkedList<ListNode>();
        for (ListNode current = head; current != null; current = current.next) {
            if (nodeQueue.size() == n + 1) {
                nodeQueue.poll();
            }
            nodeQueue.offerLast(current);
        }
        if (nodeQueue.size() <= n) {
            return null;
        }
        nodeQueue.getLast().next = head;

        ListNode newTail = nodeQueue.getFirst();
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

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

        public Tests(ListNode list, int number, ListNode expectedResult) {
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

}
