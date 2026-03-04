public class SpecialPositionsInABinaryMatrix {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.numSpecial(new int[][] {
        { 1, 0, 0 },
        { 0, 0, 1 },
        { 1, 0, 0 }
    }));
  }
}

class Solution {
  public int numSpecial(int[][] mat) {
    var m = mat.length;
    var n = mat[0].length;

    var rows = new int[m];
    var columns = new int[n];

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        if (mat[i][j] == 1) {
          rows[i]++;
          columns[j]++;
        }
      }
    }

    var totalSpecials = 0;

    for (var i = 0; i < m; i++) {
      for (var j = 0; j < n; j++) {
        if (mat[i][j] == 1 && rows[i] == 1 && columns[j] == 1) {
          totalSpecials++;
        }
      }
    }

    return totalSpecials;
  }
}
