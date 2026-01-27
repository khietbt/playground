import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinimumCostPathWithEdgeReversals {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minCost(4, new int[][] {
        { 0, 1, 3 },
        { 3, 1, 1 },
        { 2, 3, 4 },
        { 0, 2, 2 }
    }));
  }
}

class Solution {
  public int minCost(int n, int[][] edges) {
    var graph = new HashMap<Integer, Map<Integer, Integer>>();

    for (var e : edges) {
      var u = e[0];
      var v = e[1];
      var w = e[2];
      //
      graph.computeIfAbsent(u, k -> new HashMap<>()).merge(v, w, (x, y) -> Math.min(x, y));
      graph.computeIfAbsent(v, k -> new HashMap<>()).merge(u, 2 * w, (x, y) -> Math.min(x, y));
    }

    var visited = new boolean[n];

    var costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);

    var queue = new PriorityQueue<int[]>((a, b) -> {
      return a[0] - b[0];
    });

    queue.offer(new int[] { 0, 0 });

    while (!queue.isEmpty()) {
      var node = queue.poll();

      var cost = node[0];
      var index = node[1];

      if (index == n - 1) {
        return cost;
      }

      if (visited[index]) {
        continue;
      }

      visited[index] = true;

      graph.computeIfAbsent(index, k -> new HashMap<>()).forEach((k, v) -> {
        if (cost + v < costs[k]) {
          costs[k] = cost + v;
          queue.offer(new int[] { costs[k], k });
        }
      });
    }

    return -1;
  }
}
