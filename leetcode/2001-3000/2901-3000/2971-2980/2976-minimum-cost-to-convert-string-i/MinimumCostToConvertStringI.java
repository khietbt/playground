import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToConvertStringI {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.minimumCost(
            "aaaabadaaa",
            "dbdadddbad",
            new char[] { 'c', 'a', 'c', 'a', 'a', 'b', 'b', 'b', 'd', 'd', 'c' },
            new char[] { 'a', 'c', 'b', 'd', 'b', 'c', 'a', 'd', 'c', 'b', 'd' },
            new int[] { 7, 8, 11, 9, 7, 6, 4, 6, 9, 5, 9 }));

    // System.out.println(
    // solution.minimumCost(
    // "abcd", "acbe", new char[] { 'a', 'b', 'c', 'c', 'e', 'd' },
    // new char[] { 'b', 'c', 'b', 'e', 'b', 'e' }, new int[] { 2, 5, 5, 1, 2, 20
    // }));

    // System.out.println(solution.minimumCost(
    // "aaaa",
    // "bbbb",
    // new char[] { 'a', 'c' },
    // new char[] { 'c', 'b' },
    // new int[] { 1, 2 }));
  }
}

class Solution {
  public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    var costs = new long[26][26];

    for (var i = 0; i < 26; i++) {
      Arrays.fill(costs[i], Integer.MAX_VALUE);
    }

    for (var i = 0; i < 26; i++) {
      costs[i][i] = 0;
    }

    for (int i = 0; i < cost.length; i++) {
      var o = original[i] - 'a';
      var c = changed[i] - 'a';

      costs[o][c] = Math.min(costs[o][c], cost[i]);
    }

    for (var k = 0; k < 26; k++) {
      for (var i = 0; i < 26; i++) {
        for (var j = 0; j < 26; j++) {
          costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
        }
      }
    }

    long totalCosts = 0;

    for (var i = 0; i < source.length(); i++) {
      var s = source.charAt(i) - 'a';
      var t = target.charAt(i) - 'a';

      if (costs[s][t] == Integer.MAX_VALUE) {
        return -1;
      }

      totalCosts += costs[s][t];
    }

    return totalCosts;
  }
}
