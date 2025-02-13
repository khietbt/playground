import java.util.PriorityQueue;

public class MinimumOperationsToExceedThresholdValueII {
  public static void main(String[] args) {
    // int[] nums = { 2, 11, 10, 1, 3 };
    // int k = 10;
    //
    // int[] nums = { 1, 1, 2, 4, 9 };
    // int k = 20;

    int[] nums = { 999999999, 999999999, 999999999 };
    int k = 1000000000;

    System.out.println(new Solution().minOperations(nums, k));
  }
}

class Solution {
  public int minOperations(int[] nums, int k) {
    int operations = 0;

    PriorityQueue<Long> queue = new PriorityQueue<>();

    for (long num : nums) {
      queue.offer(num);
    }

    while (!queue.isEmpty()) {
      // System.out.println(Arrays.toString(queue.toArray(Long[]::new)));
      if (queue.peek() >= k) {
        return operations;
      }

      if (queue.size() < 2) {
        break;
      }

      Long x = queue.poll();
      Long y = queue.poll();

      operations++;

      queue.offer(Math.min(x, y) * 2 + Math.max(x, y));
      // System.out.println(Arrays.toString(queue.toArray(Long[]::new)));
    }

    return -1;
  }
}
