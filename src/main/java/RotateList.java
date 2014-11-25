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
}
