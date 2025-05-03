import java.util.Arrays;

public class NumberOfWayToSplitArray {
  public static void main(String[] args) {
    int[] numbers = new int[] { 10, 4, -8, 7 };

    System.out.println(new Solution().waysToSplitArray(numbers));
  }
}

class Solution {
  public int waysToSplitArray(int[] numbers) {
    long total = Arrays.stream(numbers).mapToLong(Long::valueOf).sum();
    long accumulated = 0;

    int totalWaysToSplit = 0;

    for (int i = 0; i < numbers.length - 1; i++) {
      accumulated += numbers[i];

      if (accumulated >= total - accumulated) {
        totalWaysToSplit++;
      }
    }

    return totalWaysToSplit;
  }
}
