public class FindMinimumInRotatedSortedArray {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.findMin(
        new int[] { 4, 5, 6, 7, 0, 1, 2, 3 }));
    System.out.println(solution.findMin(
        new int[] { 4, 5, 6, 7, 0 }));
    System.out.println(solution.findMin(
        new int[] { 4, 5, 6, 7, 8, 0 }));
    System.out.println(solution.findMin(
        new int[] { -1, 4, 5, 6, 7, 8, 0 }));
  }
}

class Solution {
  public int findMin(int[] nums) {
    var n = nums.length;

    var left = 0;
    var right = n - 1;
    var minimum = Math.min(nums[left], nums[right]);

    while (left <= right) {
      var middle = left + (right - left) / 2;

      if (nums[middle] >= nums[left]) {
        minimum = Math.min(minimum, nums[left]);
        left = middle + 1;
      } else {
        minimum = Math.min(minimum, nums[middle]);
        right = middle - 1;
      }
    }

    return minimum;
  }
}
