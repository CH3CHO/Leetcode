/**
 * https://oj.leetcode.com/problems/intersection-of-two-linked-lists/
 * <p/>
 * Created by yqdong on 2014/11/28.
 */
public class LinkedListIntersection {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode lastA = headA, lastB = headB;
        int lengthA = 0, lengthB = 0;
        for (ListNode currA = headA; currA != null; lastA = currA, currA = currA.next) {
            if (currA == headB) {
                return headB;
            }
            ++lengthA;
        }
        for (ListNode currB = headB; currB != null; lastB = currB, currB = currB.next) {
            if (currB == headA) {
                return headA;
            }
            ++lengthB;
        }
        if (lastA != lastB) {
            return null;
        }
        ListNode longHead, shortHead;
        if (lengthA > lengthB) {
            longHead = headA;
            shortHead = headB;
        } else {
            longHead = headB;
            shortHead = headA;
        }
        int lengthDiff = Math.abs(lengthA - lengthB);
        for (int i = 0; i < lengthDiff; ++i, longHead = longHead.next) {
        }
        for (; longHead != null; longHead = longHead.next, shortHead = shortHead.next) {
            if (longHead == shortHead) {
                return longHead;
            }
        }
        return null;
    }
}
