import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minimumDifference(new int[] { 90 }, 1));
    System.out.println(solution.minimumDifference(new int[] { 9, 4, 1, 7 }, 2));
  }
}

class Solution {
  public int minimumDifference(int[] nums, int k) {
    Arrays.sort(nums);

    // if (nums.length == k) {
    // return nums[k - 1] - nums[0];
    // }

    var min = Integer.MAX_VALUE;

    for (var i = 0; i < nums.length - k + 1; i++) {
      // System.out.println(i + " " + (i + k) + " " + ", nums[i] = " + nums[i] + ",
      // nums[i + k] = " + nums[i + k]);

      var difference = nums[i + k - 1] - nums[i];

      min = Math.min(min, difference);
    }

    return min;
  }
}
