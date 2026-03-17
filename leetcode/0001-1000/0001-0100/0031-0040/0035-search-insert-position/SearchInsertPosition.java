public class SearchInsertPosition {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 5));
    System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 2));

    System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 0));
    System.out.println(solution.searchInsert(new int[] { 1, 3, 5, 6 }, 7));
  }
}

class Solution {
  public int searchInsert(int[] nums, int target) {
    var n = nums.length;

    if (target > nums[n - 1]) {
      return n;
    }

    if (target < nums[0]) {
      return 0;
    }

    var left = 0;
    var right = n - 1;

    while (left <= right) {
      var middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        return middle;
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }
}
