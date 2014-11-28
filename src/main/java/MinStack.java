import java.util.Arrays;

/**
 * Created by CH3CHO on 11/28/2014.
 */
public class MinStack {

    private int[] values = new int[4];
    private int[] mins = new int[4];
    private int count;

    public void push(int x) {
        ensureCapacity();
        values[count] = x;
        mins[count] = count != 0 ? Math.min(mins[count - 1], x) : x;
        ++count;
    }

    public void pop() {
        --count;
    }

    public int top() {
        return count != 0 ? values[count - 1] : 0;
    }

    public int getMin() {
        return count != 0 ? mins[count - 1] : 0;
    }

    private void ensureCapacity() {
        if (count < values.length) {
            return;
        }
        values = Arrays.copyOf(values, count * 2);
        mins = Arrays.copyOf(mins, count * 2);
    }
}
