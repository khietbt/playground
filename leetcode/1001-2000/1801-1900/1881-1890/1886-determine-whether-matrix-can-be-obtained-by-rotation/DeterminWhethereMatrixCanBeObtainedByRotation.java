public class DeterminWhethereMatrixCanBeObtainedByRotation {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        solution.findRotation(new int[][] {
            { 0, 1 },
            { 1, 0 }
        }, new int[][] {
            { 1, 0 },
            { 0, 1 }
        }));
  }
}

class Solution {
  public boolean findRotation(int[][] mat, int[][] target) {
    var n = mat.length;
    var rot90 = 0b1111;

    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        var cur = 0;
        cur |= (mat[i][j] == target[i][j]) ? 1 : 0;
        cur |= ((mat[j][n - 1 - i] == target[i][j] ? 1 : 0) << 1);
        cur |= ((mat[n - 1 - i][n - 1 - j] == target[i][j] ? 1 : 0) << 2);
        cur |= ((mat[n - 1 - j][i] == target[i][j] ? 1 : 0) << 3);

        rot90 &= cur;
      }
    }

    return rot90 != 0;
  }
}
