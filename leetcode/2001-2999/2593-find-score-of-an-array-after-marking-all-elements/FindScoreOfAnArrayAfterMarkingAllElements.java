import java.util.PriorityQueue;

public class FindScoreOfAnArrayAfterMarkingAllElements {
  public static void main(String[] args) {
    Solution s = new Solution();

    System.out.println(s.findScore(new int[] { 2, 1, 3, 4, 5, 2 }));
    System.out.println(s.findScore(new int[] { 2, 3, 5, 1, 3, 2 }));
    System.out.println(s.findScore(new int[] { 2, 5, 6, 6, 10 }));
    System.out.println(s.findScore(new int[] { 2, 1, 3, 4, 5, 2 }));
  }
}

class Solution {
  public long findScore(int[] numbers) {
    boolean[] marked = new boolean[numbers.length];
    PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

    for (int i = 0; i < numbers.length; i++) {
      queue.offer(new int[] { numbers[i], i });
    }

    long sum = 0;

    while (!queue.isEmpty()) {
      int[] poll = queue.poll();
      int value = poll[0];
      int currentIndex = poll[1];

      if (marked[currentIndex]) {
        continue;
      }

      int leftIndex = Math.max(0, currentIndex - 1);
      int rightIndex = Math.min(numbers.length - 1, currentIndex + 1);

      marked[currentIndex] = true;
      marked[leftIndex] = true;
      marked[rightIndex] = true;

      sum += value;

      while (!queue.isEmpty() && marked[queue.peek()[1]]) {
        queue.poll();
      }
    }

    return sum;
  }
}
