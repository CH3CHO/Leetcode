import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.Arrays;
import java.util.Collection;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * <p>
 * Created by yqdong on 2015/10/23.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final MaximumDepthOfBinaryTree SOLUTION = new MaximumDepthOfBinaryTree();

        private final TreeNode treeNode;
        private final int expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                    {TestHelper.buildTree(1, 2, null, 4, 3, null, null, 5, null, 6, 7, null, null, null, null, null, null, null, null, 8, null, null, null, null, null, null, null, null, null, null), 5},
            });
        }

        public Tests(TreeNode treeNode, int expectedResult) {
            this.treeNode = treeNode;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            int result = SOLUTION.maxDepth(treeNode);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
