import java.util.Arrays;

public class ThreeSumClosest {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1));
  }
}

class Solution {
  public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);

    var minDiff = Integer.MAX_VALUE;
    var min = Integer.MAX_VALUE;
    var n = nums.length;

    for (var i = 0; i < n - 2; i++) {
      var first = nums[i];
      var j = i + 1;
      var k = n - 1;

      while (j < k) {
        var second = nums[j];
        var third = nums[k];
        var sum = first + second + third;

        if (minDiff > Math.abs(target - sum)) {
          minDiff = Math.abs(target - sum);
          min = sum;
        }

        if (sum == target) {
          return target;
        } else if (sum > target) {
          k--;
        } else {
          j++;
        }
      }
    }
    return min;
  }
}
