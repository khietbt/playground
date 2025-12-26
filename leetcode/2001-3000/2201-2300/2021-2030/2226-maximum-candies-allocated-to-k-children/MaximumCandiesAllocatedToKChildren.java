import java.util.Arrays;

public class MaximumCandiesAllocatedToKChildren {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.maximumCandies(new int[] { 5, 8, 6 }, 3));
    System.out.println(solution.maximumCandies(new int[] { 2, 5 }, 11));
  }
}

class Solution {
  public int maximumCandies(int[] candies, long k) {
    var right = Arrays.stream(candies).max().orElse(0);
    var left = 0;

    while (left < right) {
      final var m = (left + right + 1) / 2;

      var allocatedChildren = Arrays.stream(candies).mapToLong(c -> c / m).sum();

      if (allocatedChildren >= k) {
        left = m;
      } else {
        right = m - 1;
      }
    }

    return left;
  }
}
