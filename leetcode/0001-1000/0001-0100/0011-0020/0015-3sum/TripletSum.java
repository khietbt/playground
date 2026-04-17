import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSum {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.threeSum(
        new int[] { -1, 0, 1, 2, -1, -4 }));
  }
}

class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    var n = nums.length;

    Arrays.sort(nums);

    var answer = new ArrayList<List<Integer>>();

    var i = 0;

    while (i < n) {
      var first = nums[i];
      var j = i + 1;
      var k = n - 1;

      while (j < k) {
        var second = nums[j];
        var third = nums[k];

        var sum = first + second + third;

        if (sum > 0) {
          // Move k to left
          do {
            k--;
          } while (j < k && nums[k] == nums[k + 1]);
        } else if (sum < 0) {
          // Move j to right.
          do {
            j++;
          } while (j < k && nums[j] == nums[j - 1]);
        } else {
          answer.add(Arrays.asList(first, second, third));

          // Move k to left
          do {
            k--;
          } while (j < k && nums[k] == nums[k + 1]);

          // Move j to right.
          do {
            j++;
          } while (j < k && nums[j] == nums[j - 1]);
        }
      }

      do {
        i++;
      } while (i < n && nums[i] == nums[i - 1]);
    }

    return answer;
  }
}
