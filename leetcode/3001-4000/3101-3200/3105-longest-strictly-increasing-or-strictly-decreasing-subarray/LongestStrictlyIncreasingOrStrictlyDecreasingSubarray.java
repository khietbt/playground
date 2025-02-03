public class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
  public static void main(String[] args) {
    System.out.println(new Solution().longestMonotonicSubarray(new int[] { 1, 2, 3, 2, 1, 0 }));
  }
}

class Solution {
  public int longestMonotonicSubarray(int[] nums) {
    int max = 1;
    int currentLength = 1;
    int n = nums.length;

    for (int i = 1; i < n; i++) {
      if (nums[i] > nums[i - 1]) {
        currentLength++;
        max = Math.max(currentLength, max);
      } else {
        currentLength = 1;
      }
    }

    currentLength = 1;

    for (int i = 1; i < n; i++) {
      if (nums[i] < nums[i - 1]) {
        currentLength++;
        max = Math.max(currentLength, max);
      } else {
        currentLength = 1;
      }
    }

    return max;
  }
}
