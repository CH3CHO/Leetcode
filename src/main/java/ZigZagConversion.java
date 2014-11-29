import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by CH3CHO on 11/29/2014.
 */
public class ZigZagConversion {

    public String convert(String s, int nRows) {
        int groupCharCount = nRows + Math.max(0, nRows - 2);
        StringBuilder[] rowBuilders = new StringBuilder[nRows];
        for (int i = 0; i < nRows; ++i) {
            rowBuilders[i] = new StringBuilder();
        }
        for (int i = 0; i < s.length(); ++i) {
            int diff = i % groupCharCount;
            int targetRow;
            if (diff < nRows) {
                targetRow = diff;
            } else {
                targetRow = (nRows - 1) * 2 - diff;
            }
            rowBuilders[targetRow].append(s.charAt(i));
        }
        StringBuilder resultBuilder = new StringBuilder();
        for (StringBuilder builder : rowBuilders) {
            resultBuilder.append(builder.toString());
        }
        return resultBuilder.toString();
    }

    @RunWith(Parameterized.class)
    public static class Tests {

        private static final ZigZagConversion SOLUTION = new ZigZagConversion();

        private final String text;
        private final int nRow;
        private final String expectedResult;

        @Parameterized.Parameters
        public static Collection<Object[]> data() {
            return Arrays.asList(new Object[][]{
                            {"PAYPALISHIRING", 5, "PHASIYIRPLIGAN"},
                            {"PAYPALISHIRING", 4, "PINALSIGYAHRPI"},
                            {"PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"},
                            {"PAYPALISHIRING", 2, "PYAIHRNAPLSIIG"},
                            {"PAYPALISHIRING", 1, "PAYPALISHIRING"},
                    }
            );
        }

        public Tests(String text, int nRow, String expectedResult) {
            this.text = text;
            this.nRow = nRow;
            this.expectedResult = expectedResult;
        }

        @Test
        public void test() {
            String result = SOLUTION.convert(text, nRow);
            Assert.assertEquals(expectedResult, result);
        }
    }
}
