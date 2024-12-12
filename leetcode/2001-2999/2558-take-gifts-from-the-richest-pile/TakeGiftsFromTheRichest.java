import java.util.PriorityQueue;

public class TakeGiftsFromTheRichest {
  public static void main(String[] args) {
    int[] gifts = { 25, 64, 9, 100, 4 };
    int k = 4;

    System.out.println((new Solution()).pickGifts(gifts, k));
  }
}

class Solution {
  public long pickGifts(int[] gifts, int k) {
    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);

    for (int gift : gifts) {
      queue.offer(gift);
    }

    while (k-- > 0) {
      int max = queue.poll();

      queue.offer((int) Math.sqrt(max));
    }

    System.out.println(queue);

    return queue.stream().mapToLong(Long::valueOf).reduce(0, Long::sum);
  }
}
