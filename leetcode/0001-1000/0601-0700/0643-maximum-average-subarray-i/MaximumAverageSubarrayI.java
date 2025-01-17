public class MaximumAverageSubarrayI {
  public static void main(String[] args) {
    int[] numbers = new int[] {
        1, 12, -5, -6, 50, 3
    };

    int k = 4;

    System.out.println(new Solution().findMaxAverage(numbers, k));

  }
}

class Solution {
  public double findMaxAverage(int[] numbers, int k) {
    double sum = .0;
    double max = -Double.MAX_VALUE;

    for (int i = 0; i < numbers.length; i++) {
      sum += numbers[i];

      if (i >= k) {
        sum -= numbers[i - k];
      }

      if (i >= k - 1) {
        max = Math.max(max, sum / k);
      }
    }

    return max;
  }
}
