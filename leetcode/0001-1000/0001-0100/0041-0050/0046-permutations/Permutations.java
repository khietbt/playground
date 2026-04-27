import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.permute(
        new int[] { 1, 2, 3 }));

    System.out.println(solution.permute(
        new int[] { 1, 1, 2 }));

    // System.out.println(solution.permute(
    // new int[] { 1, 2, 3, 4, 5, 6 }));
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
      swap(nums, i++, j--);
    }
  }

  List<Integer> next(int nums[]) {
    var n = nums.length;
    var pivot = Integer.MIN_VALUE;

    for (var i = n - 2; i >= 0; i--) {
      if (nums[i] < nums[i + 1]) {
        pivot = i;
        break;
      }
    }

    if (pivot == Integer.MIN_VALUE) {
      return new ArrayList<>();
    }

    for (var i = n - 1; i >= 0; i--) {
      if (nums[i] > nums[pivot]) {
        swap(nums, i, pivot);
        break;
      }
    }

    reverse(nums, pivot + 1, n - 1);

    return Arrays.stream(nums).boxed().toList();
  }

  public List<List<Integer>> permute(int[] nums) {
    Arrays.sort(nums);

    var permutations = new ArrayList<List<Integer>>();

    permutations.add(Arrays.stream(nums).boxed().toList());

    while (true) {
      var permutation = next(nums);

      if (permutation.isEmpty()) {
        break;
      }

      permutations.add(permutation);
    }

    return permutations;
  }
}
