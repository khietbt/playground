public class LongestSubarrayOf1sAfterDeletingOneElement {
  public static void main(String[] args) {
    // int[] numbers = new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 };
    int[] numbers = new int[] { 1, 1, 1, 1, 1 };

    System.out.println(new Solution().longestSubarray(numbers));
  }
}

class Solution {
  public int longestSubarray(int[] numbers) {
    int length = numbers.length;
    int left = 0;
    int right = 0;

    if (length < 2) {
      return 0;
    }

    int k = 1;

    while (right < length) {
      k -= 1 - numbers[right++];

      if (k < 0) {
        k += 1 - numbers[left];
        left++;
      }
    }

    return right - left - 1;
  }
}
