import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;
import java.util.Queue;

/**
 * https://oj.leetcode.com/problems/path-sum/
 * <p/>
 * Created by CH3CHO on 11/30/2014.
 */
public class PathSum {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        Queue<State> queue = new ArrayDeque<State>();
        queue.add(new State(root, 0));

        while (!queue.isEmpty()) {
            State state = queue.poll();
            TreeNode node = state.node;
            int nodeVal = node.val;
            int currSum = state.sum + nodeVal;
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                if (currSum == sum) {
                    return true;
                }
            } else {
                if (left != null) {
                    queue.add(new State(left, currSum));
                }
                if (right != null) {
                    queue.add(new State(right, currSum));
                }
            }
        }

        return false;
    }

    private static class State {
        public final TreeNode node;
        public final int sum;

        public State(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final PathSum SOLUTION = new PathSum();

        private final TreeNode root;
        private final int sum;
        private final boolean expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {TestHelper.buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1), 22, true},
                            {TestHelper.buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1), 26, true},
                            {TestHelper.buildTree(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, null, null, 1), 27, false},
                    }
            );
        }

        public Tests(TreeNode root, int sum, boolean expectedResult) {
            this.root = root;
            this.sum = sum;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            boolean result = SOLUTION.hasPathSum(root, sum);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
