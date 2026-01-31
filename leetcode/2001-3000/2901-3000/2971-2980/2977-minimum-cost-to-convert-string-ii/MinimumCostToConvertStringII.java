import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class MinimumCostToConvertStringII {

  public static void main(String[] args) {
    var solution = new Solution();

    // System.out.println(
    // solution.minimumCost(
    // "abcd",
    // "acbe",
    // new String[] { "a", "b", "c", "c", "e", "d" },
    // new String[] { "b", "c", "b", "e", "b", "e" },
    // new int[] { 2, 5, 5, 1, 2, 20 }));

    System.out.println(
        solution.minimumCost(
            "abcdefgh",
            "acdeeghh",
            new String[] { "bcd", "fgh", "thh" },
            new String[] { "cde", "thh", "ghh" },
            new int[] { 1, 3, 5 }));

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
  public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
    var indices = new HashMap<String, Integer>();

    for (var o : original) {
      indices.computeIfAbsent(o, k -> indices.size());
    }

    for (var c : changed) {
      indices.computeIfAbsent(c, k -> indices.size());
    }

    var totalIndices = indices.size();
    var costs = new long[totalIndices][totalIndices];

    for (var r : costs) {
      Arrays.fill(r, Integer.MAX_VALUE);
    }

    for (var i = 0; i < totalIndices; i++) {
      costs[i][i] = 0;
    }

    for (var k = 0; k < cost.length; k++) {
      var o = original[k];
      var c = changed[k];

      var i = indices.get(o);
      var j = indices.get(c);

      costs[i][j] = Math.min(costs[i][j], cost[k]);
    }

    for (var k = 0; k < totalIndices; k++) {
      for (var i = 0; i < totalIndices; i++) {
        for (var j = 0; j < totalIndices; j++) {
          costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
        }
      }
    }

    var n = source.length();
    var dp = new long[n + 1];

    Arrays.fill(dp, Long.MAX_VALUE);
    dp[0] = 0;

    var lens = indices.keySet().stream().map(String::length).collect(Collectors.toSet());

    for (var k = 0; k < n; k++) {
      if (dp[k] == Long.MAX_VALUE) {
        continue;
      }

      if (source.charAt(k) == target.charAt(k)) {
        dp[k + 1] = Math.min(dp[k + 1], dp[k]);
      }

      for (var l : lens) {
        if (k + l > n) {
          continue;
        }

        var s = source.substring(k, k + l);
        var t = target.substring(k, k + l);

        var i = indices.get(s);
        var j = indices.get(t);

        if (i == null || j == null) {
          continue;
        }

        if (costs[i][j] < Integer.MAX_VALUE) {
          dp[k + l] = Math.min(dp[k + l], dp[k] + costs[i][j]);
        }
      }
    }

    return dp[n] == Long.MAX_VALUE ? -1 : dp[n];
  }
}

// class Solution {
// public long minimumCost(String source, String target, char[] original, char[]
// changed, int[] cost) {
// var costs = new long[26][26];
//
// for (var i = 0; i < 26; i++) {
// Arrays.fill(costs[i], Integer.MAX_VALUE);
// }
//
// for (var i = 0; i < 26; i++) {
// costs[i][i] = 0;
// }
//
// for (int i = 0; i < cost.length; i++) {
// var o = original[i] - 'a';
// var c = changed[i] - 'a';
//
// costs[o][c] = Math.min(costs[o][c], cost[i]);
// }
//
// for (var k = 0; k < 26; k++) {
// for (var i = 0; i < 26; i++) {
// for (var j = 0; j < 26; j++) {
// costs[i][j] = Math.min(costs[i][j], costs[i][k] + costs[k][j]);
// }
// }
// }
//
// long totalCosts = 0;
//
// for (var i = 0; i < source.length(); i++) {
// var s = source.charAt(i) - 'a';
// var t = target.charAt(i) - 'a';
//
// if (costs[s][t] == Integer.MAX_VALUE) {
// return -1;
// }
//
// totalCosts += costs[s][t];
// }
//
// return totalCosts;
// }
// }
