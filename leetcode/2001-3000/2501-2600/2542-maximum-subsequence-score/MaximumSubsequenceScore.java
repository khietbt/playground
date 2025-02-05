import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {
  public static void main(String[] args) {
    int[] lhs = { 2, 1, 14, 12 };
    int[] rhs = { 11, 7, 13, 6 };

    System.out.println(new Solution().maxScore(lhs, rhs, 3));
  }
}

// 14, 2, 1, 12
// 13, 11, 7, 6
// 17 * 7 = 119

class Solution {
  public long maxScore(int[] lhs, int[] rhs, int k) {
    int n = lhs.length;

    int[][] pairs = new int[n][2];

    for (int i = 0; i < n; i++) {
      pairs[i] = new int[] { lhs[i], rhs[i] };
    }

    Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

    long max = 0;
    long sum = 0;

    PriorityQueue<Integer> queue = new PriorityQueue<>(k);

    for (int i = 0; i < n; i++) {
      sum += pairs[i][0];
      queue.offer(pairs[i][0]);

      if (i >= k - 1) {
        max = Math.max(max, sum * pairs[i][1]);

        // Prepare for the next round.
        sum -= queue.poll();
      }
    }

    return max;
  }
}
