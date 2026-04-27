import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

  public static void main(String[] args) {
    var solution = new Solution();

    solution.permuteUnique(new int[] { 1, 1, 2, 2, 3, 3, 4, 4 }).forEach(
        l -> System.out.println(l));
  }
}

class Solution {
  public List<List<Integer>> permuteUnique(int[] nums) {
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

}
