import java.util.Deque;
import java.util.LinkedList;

public class ContinuousSubarrays {
  public static void main(String[] args) {
    System.out.println((new Solution()).continuousSubarrays(new int[] { 5, 4, 2, 4 }));
    System.out.println((new Solution()).continuousSubarrays(new int[] { 1, 2, 3 }));
  }
}

class Solution {
  public long continuousSubarrays(int[] numbers) {
    long totalContinuousSubarrays = 0;

    Deque<Integer> maximums = new LinkedList<>();
    Deque<Integer> minimums = new LinkedList<>();

    int right = 0;
    int left = 0;

    for (; right < numbers.length; right++) {
      while (!maximums.isEmpty() && numbers[right] > numbers[maximums.peekLast()]) {
        maximums.pollLast();
      }

      while (!minimums.isEmpty() && numbers[right] < numbers[minimums.peekLast()]) {
        minimums.pollLast();
      }

      maximums.offerLast(right);
      minimums.offerLast(right);

      while (numbers[maximums.peekFirst()] - numbers[minimums.peekFirst()] > 2) {
        left++;

        if (minimums.peekFirst() < left) {
          minimums.pollFirst();
        }

        if (maximums.peekFirst() < left) {
          maximums.pollFirst();
        }
      }

      totalContinuousSubarrays += right - left + 1;
    }

    return totalContinuousSubarrays;
  }
}
