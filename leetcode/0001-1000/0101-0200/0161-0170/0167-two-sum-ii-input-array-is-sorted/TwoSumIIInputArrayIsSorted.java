import java.util.Arrays;

public class TwoSumIIInputArrayIsSorted {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(Arrays.toString(
        solution.twoSum(new int[] { 2, 7, 11, 15 }, 9)));
  }
}

class Solution {
  public int[] twoSum(int[] numbers, int target) {
    var left = 0;
    var right = numbers.length - 1;

    while (numbers[left] + numbers[right] != target) {
      if (numbers[left] + numbers[right] > target) {
        right--;
        continue;
      }

      left++;
    }

    return new int[] { left + 1, right + 1 };
  }
}
