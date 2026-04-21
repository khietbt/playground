import java.util.Arrays;

public class RotateArray {

  public static void main(String[] args) {
    var solution = new Solution();

    var nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
    var k = 3;

    solution.rotate(nums, k);

    System.out.println(Arrays.toString(nums));
  }
}

class Solution {
  void swap(int nums[], int i, int j) {
    var t = nums[i];
    nums[i] = nums[j];
    nums[j] = t;
  }

  void reverse(int nums[], int i, int j) {
    while (i < j) {
      swap(nums, i, j);
      i++;
      j--;
    }
  }

  public void rotate(int[] nums, int k) {
    k = k % nums.length;

    var n = nums.length;
    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
  }
}
