import java.util.ArrayDeque;
import java.util.Deque;

public class NumberOfRecentCalls {
  public static void main(String[] args) {
    //
  }
}

class RecentCounter {
  Deque<Integer> queue;

  public RecentCounter() {
    queue = new ArrayDeque<>();
  }

  public int ping(int t) {
    while (!queue.isEmpty() && queue.peekFirst() < t - 3000) {
      queue.pollFirst();
    }

    queue.offerLast(t);

    return queue.size();
  }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
