import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;

/**
 * Created by CH3CHO on 11/29/2014.
 */
public class EvalRPN {

    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                int right = stack.pop();
                stack.push(stack.pop() - right);
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                int right = stack.pop();
                stack.push(stack.pop() / right);
            } else {
                Integer val = Integer.parseInt(token);
                stack.push(val);
            }
        }
        return stack.peek();
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final EvalRPN SOLUTION = new EvalRPN();

        private final String[] input;
        private final int expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {new String[]{"2", "1", "+", "3", "*"}, 9},
                            {new String[]{"4", "13", "5", "/", "+"}, 6},
                            {new String[]{}, 0},
                    }
            );
        }

        public Tests(String[] input, int expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            int result = SOLUTION.evalRPN(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}