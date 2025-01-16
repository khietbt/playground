public class MaxConsecutiveOnesIII {
  public static void main(String[] args) {
    int[] numbers = new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };

    int k = 2;

    System.out.println(new Solution().longestOnes(numbers, k));
  }
}

class Solution {
  public int longestOnes(int[] numbers, int k) {
    int left = 0;
    int right = 0;
    int max = 0;
    int length = numbers.length;

    while (right < length) {
      if (numbers[right] == 0) {
        k--;
      }

      right++;

      while (k < 0) {
        if (numbers[left] == 0) {
          k++;
        }

        left++;
      }

      max = Math.max(max, right - left);
    }

    return max;
  }
}
