import java.util.ArrayList;
import java.util.List;

public class FindEventualSafeStates {
  public static void main(String[] args) {
    int[][] graph = {
        { 1, 2 },
        { 2, 3 },
        { 5 },
        { 0 },
        { 5 },
        {},
        {}
    };

    System.out.println(new Solution().eventualSafeNodes(graph));
  }
}

class Solution {
  boolean isEventual(int[][] graph, int node, boolean[] seen, boolean[] eventuals) {
    if (seen[node] || eventuals[node]) {
      return eventuals[node];
    }

    seen[node] = true;

    for (int neighbour : graph[node]) {
      if (!isEventual(graph, neighbour, seen, eventuals)) {
        return false;
      }
    }

    eventuals[node] = true;

    return true;
  }

  public List<Integer> eventualSafeNodes(int[][] graph) {
    // Number of nodes
    int n = graph.length;

    boolean[] eventuals = new boolean[n];
    boolean[] seen = new boolean[n];

    for (int i = 0; i < n; i++) {
      if (isEventual(graph, i, seen, eventuals)) {
        eventuals[i] = true;
      }
    }

    List<Integer> results = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      if (eventuals[i]) {
        results.add(i);
      }
    }
    return results;
  }
}
