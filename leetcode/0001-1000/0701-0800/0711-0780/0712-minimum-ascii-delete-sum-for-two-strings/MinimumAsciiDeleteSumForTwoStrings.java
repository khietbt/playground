public class MinimumAsciiDeleteSumForTwoStrings {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minimumDeleteSum("sea", "eat"));
    System.out.println(solution.minimumDeleteSum("delete", "leet"));
  }
}

class Solution {
  public int minimumDeleteSum(String s1, String s2) {
    var m = s1.length();
    var n = s2.length();

    var data = new int[m + 1][n + 1];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        if (s1.charAt(i) == s2.charAt(j)) {
          data[i + 1][j + 1] = data[i][j] + s1.charAt(i);
          continue;
        }

        data[i + 1][j + 1] = Math.max(data[i + 1][j], data[i][j + 1]);
      }
    }

    var total = 0;

    for (var c : s1.toCharArray()) {
      total += c;
    }

    for (var c : s2.toCharArray()) {
      total += c;
    }

    return total - 2 * data[m][n];
  }
}
