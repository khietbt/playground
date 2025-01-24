import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
  public static void main(String[] args) {
    int n = 6;
    int[][] connections = {
        { 0, 1 }, { 1, 3 }, { 2, 3 }, { 4, 0 }, { 4, 5 }
    };

    // console.log(minReorder(6, [[0, 1], [1, 3], [2, 3], [4, 0], [4, 5]]));
    System.out.println(new Solution().minReorder(n, connections));
  }
}

class Solution {
  int visit(int city, Map<Integer, List<Integer>> graph, boolean[] visited) {
    int totalReorders = 0;

    if (visited[city]) {
      return 0;
    }

    visited[city] = true;

    for (int k : graph.get(city)) {
      int neighbour = Math.abs(k);

      if (visited[neighbour]) {
        continue;
      }

      if (k < 0) {
        totalReorders++;
      }

      totalReorders += visit(neighbour, graph, visited);
    }

    return totalReorders;
  }

  public int minReorder(int n, int[][] connections) {
    Map<Integer, List<Integer>> graph = new HashMap<>();

    for (int[] connection : connections) {
      int from = connection[0];
      int to = connection[1];

      graph.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
      graph.computeIfAbsent(from, k -> new ArrayList<>()).add(-to);
    }

    return visit(0, graph, new boolean[n]);
  }
}
