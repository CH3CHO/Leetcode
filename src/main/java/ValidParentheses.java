import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.*;

/**
 * https://oj.leetcode.com/problems/valid-parentheses/
 * <p/>
 * Created by CH3CHO on 11/30/2014.
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        final Map<Character, Character> parenMapping = new HashMap<Character, Character>();
        parenMapping.put(')', '(');
        parenMapping.put(']', '[');
        parenMapping.put('}', '{');

        Stack<Character> parenStack = new Stack<Character>();
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '[':
                case '{':
                    parenStack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if (parenStack.empty()) {
                        return false;
                    }
                    char topParen = parenStack.pop();
                    if (topParen != parenMapping.get(ch)) {
                        return false;
                    }
            }
        }
        return parenStack.empty();
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final ValidParentheses SOLUTION = new ValidParentheses();

        private final String input;
        private final boolean expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {"()[]{}", true},
                            {"(]", false},
                            {"(]", false},
                            {"([)]", false},
                    }
            );
        }

        public Tests(String input, boolean expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            boolean result = SOLUTION.isValid(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
