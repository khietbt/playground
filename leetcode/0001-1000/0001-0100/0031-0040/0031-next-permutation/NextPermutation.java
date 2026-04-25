import java.util.Arrays;

public class NextPermutation {

  public static void main(String[] args) {
    var solution = new Solution();
    var nums = new int[] { 1, 2, 3 };

    solution.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    solution.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    solution.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    solution.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    solution.nextPermutation(nums);
    System.out.println(Arrays.toString(nums));

    solution.nextPermutation(nums);
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

  public void nextPermutation(int[] nums) {
    var n = nums.length;
    var pivot = Integer.MIN_VALUE;

    for (var i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        pivot = i;
        break;
      }
    }

    if (pivot == Integer.MIN_VALUE) {
      reverse(nums, 0, n - 1);
      return;
    }

    for (var i = n - 1; i >= 0; i--) {
      if (nums[i] > nums[pivot]) {
        swap(nums, i, pivot);
        break;
      }
    }

    reverse(nums, pivot + 1, n - 1);
  }
}
