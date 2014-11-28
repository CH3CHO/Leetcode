import java.util.ArrayList;
import java.util.List;

/**
 * Created by CH3CHO on 11/28/2014.
 */
public class ReverseInteger {

    public int reverse(int x) {
        List<Integer> digits = new ArrayList<Integer>();
        boolean negative = x < 0;
        x = Math.abs(x);
        do {
            digits.add(x % 10);
            x /= 10;
        } while (x != 0);

        long result = 0;
        for (int i = digits.size() - 1, time = 1; i >= 0; --i, time *= 10) {
            long num = (long)digits.get(i) * time;
            result += num;
        }
        if (negative) {
            result = -result;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int)result;
    }
}
