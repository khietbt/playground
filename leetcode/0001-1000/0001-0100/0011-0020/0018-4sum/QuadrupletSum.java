import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadrupletSum {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0));
  }
}

class Solution {
  public List<List<Integer>> fourSum(int[] nums, int target) {
    Arrays.sort(nums);

    var answer = new ArrayList<List<Integer>>();

    var n = nums.length;
    var i = 0;

    while (i < n - 3) {
      var first = nums[i];

      var j = i + 1;

      while (j < n - 2) {
        var second = nums[j];

        var k = j + 1;
        var l = n - 1;

        while (k < l) {
          var third = nums[k];
          var fourth = nums[l];

          var sum = first + second + third + fourth;

          if (sum > target) {
            do {
              l--;
            } while (k < l && nums[l] == nums[l + 1]);
          } else if (sum < target) {
            do {
              k++;
            } while (k < l && nums[k] == nums[k - 1]);
          } else {
            answer.add(Arrays.asList(first, second, third, fourth));

            do {
              l--;
            } while (k < l && nums[l] == nums[l + 1]);

            do {
              k++;
            } while (k < l && nums[k] == nums[k - 1]);
          }
        }

        do {
          j++;
        } while (j < n - 2 && nums[j] == nums[j - 1]);
      }

      do {
        i++;
      } while (i < n && nums[i] == nums[i - 1]);
    }

    return answer;
  }
}
