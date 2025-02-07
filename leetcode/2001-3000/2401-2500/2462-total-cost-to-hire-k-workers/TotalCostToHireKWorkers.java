import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {
  public static void main(String[] args) {
    // int[] costs = ;
    // int[] costs = ;

    // System.out.println(new Solution().totalCost(new int[] { 3, 2, 7, 7, 1, 2 },
    // 3, 4));
    // System.out.println(new Solution().totalCost(new int[] { 1, 2, 4, 1 }, 3, 3));
    // System.out.println(new Solution().totalCost(new int[] { 17, 12, 10, 2, 7, 2,
    // 11, 20, 8 }, 3, 4));
    // System.out.println(new Solution().totalCost(new int[] { 48 }, 1, 1));
    // System.out.println(new Solution().totalCost(new int[] { 17, 12, 10, 2, 7, 2,
    // 11, 20, 8 }, 3, 4));
    System.out.println(
        new Solution().totalCost(new int[] { 31, 25, 72, 79, 74, 65, 84, 91, 18, 59, 27, 9, 81, 33, 17, 58 }, 11, 2));
  }
}

class Solution {
  public long totalCost(int[] costs, int k, int candidates) {
    int n = costs.length;

    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> {
      if (a[0] == b[0]) {
        return a[1] - b[1];
      }

      return a[0] - b[0];
    });

    int leftIndex = candidates - 1;
    int rightIndex = n - candidates;

    // Initialize the queue;
    for (int i = 0; i < candidates; i++) {
      queue.offer(new int[] { costs[i], i });
    }

    for (int i = rightIndex; i < n; i++) {
      if (i > leftIndex) {
        queue.offer(new int[] { costs[i], i });
      }
    }

    int sum = 0;

    while (k-- > 0 && !queue.isEmpty()) {
      int[] hired = queue.poll();

      int cost = hired[0];
      int hiredIndex = hired[1];

      sum += cost;

      if (hiredIndex <= leftIndex) {
        if (++leftIndex < rightIndex) {
          queue.offer(new int[] { costs[leftIndex], leftIndex });
        }
      }
      // If the element is from the right side, move left

      if (hiredIndex >= rightIndex) {
        if (--rightIndex > leftIndex) {
          queue.offer(new int[] { costs[rightIndex], rightIndex });
        }
      }
    }

    return sum;
  }
}
