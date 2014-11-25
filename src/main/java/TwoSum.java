import java.util.HashMap;
import java.util.Map;

/**
 * Created by yqdong on 2014/11/25.
 */
public class TwoSum {

    public int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; ++i) {
            int number = numbers[i];
            int diff = target - number;
            if (numberMap.containsKey(diff)) {
                return new int[]{numberMap.get(diff).intValue() + 1, i + 1};
            }
            numberMap.put(number, i);
        }
        return null;
    }
}
