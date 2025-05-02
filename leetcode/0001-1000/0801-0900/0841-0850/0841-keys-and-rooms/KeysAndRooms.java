import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class KeysAndRooms {
  public static void main(String[] args) {
    List<List<Integer>> rooms = Arrays.asList(
        Arrays.asList(1, 3),
        Arrays.asList(3, 0, 1),
        Arrays.asList(2),
        Arrays.asList(0));

    System.out.println(new Solution().canVisitAllRooms(rooms));
  }
}

class Solution {
  public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    Set<Integer> unlockables = new HashSet<>();
    unlockables.add(0);

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(0);

    while (!queue.isEmpty()) {
      int key = queue.poll();
      List<Integer> keys = rooms.get(key);

      for (int k : keys) {
        if (unlockables.add(k)) {
          queue.offer(k);
        }
      }
    }

    return unlockables.size() == rooms.size();
  }
}
