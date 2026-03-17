public class SearchInRotatedSortedArray {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
    System.out.println(solution.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3));
    System.out.println(solution.search(new int[] { 1 }, 0));
    System.out.println(solution.search(new int[] { 1 }, 2));
  }
}

class Solution {
  public int search(int[] nums, int target) {
    if (nums.length == 1) {
      return nums[0] == target ? 0 : -1;
    }

    var left = 0;
    var right = nums.length - 1;

    while (left <= right) {
      if (nums[left] == target) {
        return left;
      }

      if (nums[right] == target) {
        return right;
      }

      var middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        return middle;
      }

      if (nums[middle] > nums[right]) {
        if (target > nums[left] && nums[middle] > target) {
          // [left, middle] is ascending AND nums[left] < target < nums[middle]
          // ==> the new range is [left, middle - 1]
          right = middle - 1;
        } else {
          // the new range is [middle + 1, right]
          left = middle + 1;
        }
        //
      } else {
        // [middle, right] is ascending AND nums[middle] < target < nums[right]
        // ==> the new range is [middle + 1, right]
        if (nums[middle] < target && target < nums[right]) {
          left = middle + 1;
        } else {
          // the new range is [left, middle - 1]
          right = middle - 1;
        }
      }
    }

    return -1;
  }
}
