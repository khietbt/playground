import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumEmployeesToBeInvitedToAMeeting {
  public static void main(String[] args) {
    System.out
        .println(new Solution().maximumInvitations(new int[] { 1, 0, 3, 2, 5, 6, 7, 4, 9, 8, 11, 10, 11, 12, 10 }));
  }
}

class Solution {
  int maxCircleSize(int[] favourites) {
    int n = favourites.length;
    int max = 0;
    boolean[] seen = new boolean[n];

    for (int i = 0; i < n; i++) {
      int current = i;

      if (seen[current]) {
        continue;
      }

      List<Integer> circle = new ArrayList<>();

      while (!seen[current]) {
        seen[current] = true;
        circle.add(current);
        current = favourites[current];
      }

      for (int j = 0; j < circle.size(); j++) {
        if (circle.get(j) == current) {
          max = Math.max(max, circle.size() - j);
          break;
        }
      }
    }

    return max;
  }

  int maxChainLength(int[] favourites) {
    int n = favourites.length;
    int[] levels = new int[n];
    int[] distances = new int[n];
    Arrays.fill(distances, 1);

    for (int f : favourites) {
      levels[f]++;
    }

    Queue<Integer> queue = new LinkedList<>();

    for (int i = 0; i < n; i++) {
      if (levels[i] == 0) {
        queue.offer(i);
      }
    }

    while (!queue.isEmpty()) {
      int current = queue.poll();

      int next = favourites[current];

      distances[next] = Math.max(distances[current] + 1, distances[next]);

      levels[next]--;

      if (levels[next] == 0) {
        queue.offer(next);
      }
    }

    int total = 0;

    for (int i = 0; i < n; i++) {
      if (i == favourites[favourites[i]]) {
        total += distances[i];
      }
    }

    return total;
  }

  public int maximumInvitations(int[] favourites) {
    return Math.max(maxCircleSize(favourites), maxChainLength(favourites));
  }
}
