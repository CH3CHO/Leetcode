package model;

/**
 * Created by yqdong on 2014/11/25.
 */
public class ListNode {
    public int val;
    public     ListNode next;

    public ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return String.valueOf(val);
    }
}
