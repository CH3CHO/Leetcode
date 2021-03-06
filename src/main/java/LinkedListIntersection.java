import model.ListNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.Arrays;
import java.util.Collection;

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

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final LinkedListIntersection SOLUTION = new LinkedListIntersection();

        private final ListNode l1, l2, expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {TestHelper.buildInternList(1, 2, 3, 4, 5), TestHelper.buildInternList(6, 7, 2, 3, 4, 5), TestHelper.getInternNode(2)},
                    {TestHelper.buildInternList(12, 13, 14, 15), TestHelper.buildInternList(12, 13, 14, 15), TestHelper.buildInternList(12)},
                    {TestHelper.buildInternList(21, 22, 23), TestHelper.buildInternList(24, 25, 26), null},
                    {TestHelper.buildInternList(31, 32, 33, 34, 35), TestHelper.buildInternList(32, 33, 34, 35), TestHelper.buildInternList(32)},
                    {TestHelper.buildInternList(42, 43, 44, 45), TestHelper.buildInternList(41, 42, 43, 44, 45), TestHelper.buildInternList(42)},
            });
        }

        public Tests(ListNode l1, ListNode l2, ListNode expectedResult) {
            this.l1 = l1;
            this.l2 = l2;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            ListNode result = SOLUTION.getIntersectionNode(l1, l2);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
