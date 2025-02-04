import java.util.PriorityQueue;

public class KthLargestElementInAnArray {
  public static void main(String[] args) {
    int[] numbers = { 3, 2, 3, 1, 2, 4, 5, 5, 6 };
    int k = 4;

    System.out.println(new Solution().findKthLargest(numbers, k));
  }
}

class Solution {
  public int findKthLargest(int[] numbers, int k) {
    if (k > numbers.length) {
      return -1;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>();

    for (int i = 0; i < numbers.length; i++) {
      queue.offer(numbers[i]);

      if (queue.size() > k) {
        queue.poll();
      }
    }

    return queue.poll();
  }
}
