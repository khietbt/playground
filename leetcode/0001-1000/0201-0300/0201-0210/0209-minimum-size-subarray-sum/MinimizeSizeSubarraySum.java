public class MinimizeSizeSubarraySum {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 4 }));
    System.out.println(solution.minSubArrayLen(4, new int[] { 2, 3, 1, 2, 4, 4 }));
  }
}

class Solution {
  public int minSubArrayLen(int target, int[] nums) {
    var n = nums.length;

    var p = new int[n + 1];

    for (var i = 0; i < n; i++) {
      p[i + 1] = p[i] + nums[i];
    }

    if (p[n] < target) {
      return 0;
    }

    var minimum = n;
    var left = n;
    var right = n;

    while (left >= 0 && right >= left) {
      if (p[right] - p[left] >= target) {
        minimum = Math.min(minimum, right - left);
        right--;
        continue;
      }

      left--;
    }

    return minimum;
  }
}
