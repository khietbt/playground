import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {
  public static void main(String[] args) {
    int[] nums = { 2, 11, 10, 1, 3 };
    int k = 10;

    System.out.println(new Solution().minOperations(nums, k));
  }
}

class Solution {
  public int minOperations(int[] nums, int k) {
    int operations = 0;

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int num : nums) {
      queue.offer(num);
    }

    while (queue.size() >= 2) {
      int x = queue.poll();
      int y = queue.poll();

      if (x > k) {
        return operations;
      }

      operations++;

      queue.offer(Math.min(x, y) * Math.max(x, y));
    }

    return -1;
  }
}
