/**
 * Created by yqdong on 2014/11/25.
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode[] result = new ListNode[2]; // [0] = root, [1] = last;
        int carry = 0;
        for (ListNode n1 = l1, n2 = l2; n1 != null || n2 != null;
             n1 = getNext(n1), n2 = getNext(n2)) {
            int val = getVal(n1) + getVal(n2) + carry;
            carry = val >= 10 ? 1 : 0;
            ListNode node = new ListNode(val >= 10 ? val - 10 : val);
            addNodeToList(result, node);
        }
        if (carry != 0) {
            ListNode node = new ListNode(1);
            addNodeToList(result, node);
        }
        return result[0];
    }

    private void addNodeToList(ListNode[] list, ListNode node) {
        if (list[1] == null) {
            list[0] = node;
        } else {
            list[1].next = node;
        }
        list[1] = node;
    }

    private ListNode getNext(ListNode n) {
        return n != null ? n.next : null;
    }

    private int getVal(ListNode n) {
        return n != null ? n.val : 0;
    }
}
