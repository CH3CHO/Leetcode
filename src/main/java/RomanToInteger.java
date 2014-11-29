import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by CH3CHO on 11/29/2014.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        final Map<Character, Integer> mapping = new HashMap<Character, Integer>();
        mapping.put('I', 1);
        mapping.put('V', 5);
        mapping.put('X', 10);
        mapping.put('L', 50);
        mapping.put('C', 100);
        mapping.put('D', 500);
        mapping.put('M', 1000);

        int result = 0;
        int prevNumber = 0;
        for (int i = 0; i < s.length(); ++i) {
            char ch = s.charAt(i);
            int number = mapping.get(ch);
            result += number;
            if (number > prevNumber) {
                result -= prevNumber << 1;
            }
            prevNumber = number;
        }
        return result;
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final RomanToInteger SOLUTION = new RomanToInteger();

        private final String input;
        private final int expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {"XXXIX", 39},
                            {"XCIX", 99},
                            {"VIII", 8},
                            {"DCCCXC", 890},
                            {"MDCCC", 1800},
                            {"CM", 900},
                    }
            );
        }

        public Tests(String input, int expectedResult) {
            this.input = input;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            int result = SOLUTION.romanToInt(input);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
