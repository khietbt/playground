import java.util.Arrays;
import java.util.function.Function;

public class FindFistAndLastPositionOfElementInSortedArray {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(Arrays.toString(
        solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));

    System.out.println(Arrays.toString(
        solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 7)));

    System.out.println(Arrays.toString(
        solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6)));

    System.out.println(Arrays.toString(
        solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 0)));
  }
}

class Solution {
  private int getFirst(int[] nums, int target) {
    var left = 0;
    var right = nums.length - 1;
    var found = -1;

    while (left <= right) {
      var middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        found = middle;
        right = middle - 1;
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return found;
  }

  private int getLast(int[] nums, int target) {
    var left = 0;
    var right = nums.length - 1;
    var found = -1;

    while (left <= right) {
      var middle = left + (right - left) / 2;

      if (nums[middle] == target) {
        left = middle + 1;
        found = middle;
      } else if (nums[middle] > target) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return found;
  }

  public int[] searchRange(int[] nums, int target) {
    return new int[] { getFirst(nums, target), getLast(nums, target) };
  }
}
