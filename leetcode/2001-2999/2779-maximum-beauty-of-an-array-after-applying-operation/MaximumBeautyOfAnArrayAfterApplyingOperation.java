import java.util.function.Function;

public class MaximumBeautyOfAnArrayAfterApplyingOperation {
  public static void main(String[] args) {
    int[] numbers = {
        4, 6, 1, 2
    };

    int k = 1;

    System.out.println((new Solution()).maximumBeauty(numbers, k));
  }
}

class Solution {
  public int maximumBeauty(int[] numbers, int k) {
    Function<int[], Integer> max = (integers) -> {
      int m = Integer.MIN_VALUE;

      for (int integer : integers) {
        m = Math.max(m, integer);
      }

      return m;
    };

    int[] differences = new int[max.apply(numbers) + 2 * k + 2];

    for (int number : numbers) {
      differences[number]++;
      differences[number + 2 * k + 1]--;
    }

    int sum = 0;
    int maxBeauty = 0;

    for (int difference : differences) {
      sum += difference;
      maxBeauty = Math.max(sum, maxBeauty);
    }

    return maxBeauty;
  }
}
