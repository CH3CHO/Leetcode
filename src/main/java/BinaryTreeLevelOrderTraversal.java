import model.TreeNode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import util.TestHelper;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 * <p/>
 * Created by CH3CHO on 11/29/2014.
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (root != null) {
            Queue<TreeNode> nodes = new ArrayDeque<TreeNode>();
            nodes.add(root);
            for (int levelNodeCount = 1; levelNodeCount != 0; ) {
                List<Integer> levelValues = new ArrayList<Integer>();
                result.add(levelValues);

                int nextLevelNodeCount = 0;
                for (int i = 0; i < levelNodeCount; ++i) {
                    TreeNode node = nodes.poll();
                    levelValues.add(node.val);
                    if (node.left != null) {
                        ++nextLevelNodeCount;
                        nodes.add(node.left);
                    }
                    if (node.right != null) {
                        ++nextLevelNodeCount;
                        nodes.add(node.right);
                    }
                }
                levelNodeCount = nextLevelNodeCount;
            }
        }

        return result;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final BinaryTreeLevelOrderTraversal SOLUTION = new BinaryTreeLevelOrderTraversal();

        private final TreeNode input;
        private final List<List<Integer>> expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {TestHelper.buildTree(3, 9, 20, null, null, 15, 7),
                                    TestHelper.buildNestedList(new Integer[][]{{3}, {9, 20}, {15, 7}})},
                            {TestHelper.buildTree(1), TestHelper.buildNestedList(new Integer[][]{{1}})}
                    }
            );
        }

        public Tests(TreeNode input, List<List<Integer>> expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            List<List<Integer>> result = SOLUTION.levelOrder(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
