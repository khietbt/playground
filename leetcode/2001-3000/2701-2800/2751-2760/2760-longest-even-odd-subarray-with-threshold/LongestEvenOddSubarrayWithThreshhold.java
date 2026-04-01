public class LongestEvenOddSubarrayWithThreshhold {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.longestAlternatingSubarray(new int[] { 3, 2, 5, 4
    }, 5));
    // System.out.println(solution.longestAlternatingSubarray(new int[] { 2, 3, 4, 5
    // }, 4));
    // System.out.println(solution.longestAlternatingSubarray(new int[] { 1, 2 },
    // 2));
    // System.out.println(solution.longestAlternatingSubarray(new int[] { 1, 3, 5 },
    // 6));
    // System.out.println(solution.longestAlternatingSubarray(new int[] { 1, 3, 4, 5
    // }, 6));
    // System.out.println(solution.longestAlternatingSubarray(new int[] { 4 }, 1));
    // System.out.println(solution.longestAlternatingSubarray(new int[] { 2, 4 },
    // 2));
  }
}

class Solution {
  public int longestAlternatingSubarray(int[] nums, int threshold) {
    var n = nums.length;
    var maximum = 0;

    for (int r = 0, l = 0; r < n && l < n; r++) {
      if (nums[r] > threshold) {
        l = r + 1;
      }

      while (l < n && nums[l] % 2 == 1) {
        l++;
      }

      if (r > l && nums[r] % 2 == nums[r - 1] % 2) {
        l = r;
      }

      if (nums[r] <= threshold && (l == r || (r > 0 && nums[r] % 2 != nums[r - 1] % 2))) {
        maximum = Math.max(maximum, r - l + 1);
      }
    }

    return maximum;

  }
}
