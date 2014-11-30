import model.ListNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 * <p/>
 * Created by CH3CHO on 11/30/2014.
 */
public class RemoveNthFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode[] nodes = new ListNode[n + 1];
        int currentTail = 0;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            nodes[currentTail++] = curr;
            if (currentTail == n + 1) {
                currentTail = 0;
            }
        }
        int nodeToDelete = currentTail == n ? 0 : currentTail + 1;
        if (nodes[currentTail] == null) {
            return head.next;
        }
        nodes[currentTail].next = nodes[nodeToDelete].next;
        return head;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final RemoveNthFromEnd SOLUTION = new RemoveNthFromEnd();

        private final ListNode head, expectedResult;
        private final int n;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {TestHelper.buildList(1, 2, 3, 4, 5), 2, TestHelper.buildList(1, 2, 3, 5)},
                    {TestHelper.buildList(1, 2, 3, 4, 5), 5, TestHelper.buildList(2, 3, 4, 5)},
                    {TestHelper.buildList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12), 5, TestHelper.buildList(1, 2, 3, 4, 5, 6, 7, 9, 10, 11, 12)},
            });
        }

        public Tests(ListNode head, int n, ListNode expectedResult) {
            this.head = head;
            this.n = n;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            ListNode result = SOLUTION.removeNthFromEnd(head, n);
            TestHelper.checkLists(expectedResult, result);
        }
    }
}
