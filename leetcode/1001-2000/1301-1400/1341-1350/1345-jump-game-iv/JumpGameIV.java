import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class JumpGameIV {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minJumps(
        new int[] { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 }));
  }
}

class Solution {
  public int minJumps(int[] arr) {
    var value2Indexes = new HashMap<Integer, List<Integer>>();
    var n = arr.length;

    for (var i = 0; i < n; i++) {
      var v = arr[i];

      value2Indexes.computeIfAbsent(v, k -> new ArrayList<>()).add(i);
    }

    var queue = new LinkedList<int[]>();
    var visited = new HashSet<Integer>();

    queue.offer(new int[] { 0, 0 });
    visited.add(0);

    while (!queue.isEmpty()) {
      var node = queue.poll();

      var currentIndex = node[0];
      var currentJumps = node[1];

      if (currentIndex == n - 2) {
        return currentJumps + 1;
      }

      if (currentIndex == n - 1) {
        return currentJumps;
      }

      var next = currentIndex + 1;

      if (!visited.contains(next)) {
        queue.offer(new int[] { next, currentJumps + 1 });
        visited.add(next);
      }

      var previous = currentIndex - 1;

      if (currentIndex > 0 && !visited.contains(previous)) {
        queue.offer(new int[] { previous, currentJumps + 1 });
        visited.add(previous);
      }

      var v = arr[currentIndex];

      if (!value2Indexes.containsKey(v)) {
        continue;
      }

      var indexes = value2Indexes.get(v);

      for (var i : indexes) {
        if (!visited.contains(i)) {
          if (i == n - 1) {
            return currentJumps + 1;
          }

          visited.add(i);
          queue.offer(new int[] { i, currentJumps + 1 });
        }
      }

      value2Indexes.remove(v);
    }

    return -1;
  }
}
