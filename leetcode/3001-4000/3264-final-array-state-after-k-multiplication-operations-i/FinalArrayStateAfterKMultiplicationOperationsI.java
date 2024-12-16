import java.util.Arrays;
import java.util.PriorityQueue;

public class FinalArrayStateAfterKMultiplicationOperationsI {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(Arrays.toString(s.getFinalState(new int[] { 1, 2 }, 3, 4)));
  }
}

class Solution {
  public int[] getFinalState(int[] numbers, int k, int multiplier) {
    PriorityQueue<Integer> queue = new PriorityQueue<>(
        (a, b) -> numbers[a] != numbers[b] ? numbers[a] - numbers[b] : a - b);

    for (int i = 0; i < numbers.length; i++) {
      queue.offer(i);
    }

    while (k-- > 0) {
      int index = queue.poll();

      numbers[index] *= multiplier;

      queue.offer(index);
    }

    return numbers;
  }
}
