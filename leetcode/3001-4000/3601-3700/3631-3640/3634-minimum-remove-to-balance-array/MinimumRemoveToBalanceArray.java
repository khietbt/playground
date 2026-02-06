import java.util.Arrays;

public class MinimumRemoveToBalanceArray {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minRemoval(
        new int[] { 1, 6, 2, 9 }, 3));

    System.out.println(
        solution.minRemoval(
            new int[] { 2, 1, 5 }, 2));
  }
}

class Solution {
  public int minRemoval(int[] nums, int k) {
    Arrays.sort(nums);

    var minimum = nums.length;
    var n = nums.length;

    for (int i = 0, j = 0; i < n && j < n; i++) {
      while (j < n && (long) (nums[i]) * k >= (long) nums[j]) {
        j++;
      }

      minimum = Math.min(minimum, n - (j - i));
    }

    return minimum;
  }
}
