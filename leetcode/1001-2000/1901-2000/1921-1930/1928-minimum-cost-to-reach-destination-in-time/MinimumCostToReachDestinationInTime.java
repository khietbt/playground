import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumCostToReachDestinationInTime {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minCost(30, new int[][] {
        { 0, 1, 10 },
        { 1, 2, 10 },
        { 2, 5, 10 },
        { 0, 3, 1 },
        { 3, 4, 10 },
        { 4, 5, 15 }
    }, new int[] {
        5, 1, 2, 20, 20, 3
    }));

    System.out.println(solution.minCost(29, new int[][] {
        { 0, 1, 10 },
        { 1, 2, 10 },
        { 2, 5, 10 },
        { 0, 3, 1 },
        { 3, 4, 10 },
        { 4, 5, 15 }
    }, new int[] {
        5, 1, 2, 20, 20, 3
    }));

    System.out.println(solution.minCost(25, new int[][] {
        { 0, 1, 10 },
        { 1, 2, 10 },
        { 2, 5, 10 },
        { 0, 3, 1 },
        { 3, 4, 10 },
        { 4, 5, 15 }
    }, new int[] {
        5, 1, 2, 20, 20, 3
    }));
  }
}

class Solution {
  public int minCost(int maxTime, int[][] edges, int[] passingFees) {
    var n = passingFees.length;

    var graph = new HashMap<Integer, Map<Integer, Integer>>();
    for (var edge : edges) {
      var x = edge[0];
      var y = edge[1];
      var t = edge[2];

      graph.computeIfAbsent(x, k -> new HashMap<>()).merge(y, t, (a, b) -> Math.min(a, b));
      graph.computeIfAbsent(y, k -> new HashMap<>()).merge(x, t, (a, b) -> Math.min(a, b));
    }

    var visitingTimes = new int[n];
    Arrays.fill(visitingTimes, Integer.MAX_VALUE);
    visitingTimes[0] = 0;

    var queue = new PriorityQueue<int[]>((a, b) -> {
      if (a[2] == b[2]) {
        return a[1] - b[1];
      }

      return a[2] - b[2];
    });

    queue.offer(
        new int[] {
            0, // city 0.
            0, // time to visit the city 0.
            passingFees[0] // fee to spend at the city 0.
        });

    while (!queue.isEmpty()) {
      var node = queue.poll();
      var index = node[0];
      var time = node[1];
      var fee = node[2];

      if (time > maxTime) {
        continue;
      }

      if (index == n - 1) {
        return fee;
      }

      graph.computeIfAbsent(index, HashMap::new).forEach(
          (k, v) -> {
            var neighbourTime = time + v;
            var neighbourFee = fee + passingFees[k];

            if (neighbourTime > maxTime || neighbourTime >= visitingTimes[k]) {
              return;
            }

            visitingTimes[k] = neighbourTime;

            queue.offer(new int[] { k, neighbourTime, neighbourFee });
          });
    }

    return -1;
  }
}
