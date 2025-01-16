import java.util.Arrays;

public class MaxNumberOfKSumPairs {
  public static void main(String[] args) {
    int[] numbers = new int[] {
        3, 1, 3, 3, 4, 6
    };

    int k = 6;

    System.out.println(new Solution().maxOperations(numbers, k));
  }
}

class Solution {
  public int maxOperations(int[] numbers, int k) {
    Arrays.sort(numbers);

    int n = 0;
    int left = 0;
    int right = numbers.length - 1;
    int sum = 0;

    while (left < right) {
      sum = numbers[left] + numbers[right];

      if (sum == k) {
        left++;
        right--;
        n++;

        continue;
      }

      if (sum > k) {
        right--;
        continue;
      }

      if (sum < k) {
        left++;
      }
    }

    return n;
  }
}
