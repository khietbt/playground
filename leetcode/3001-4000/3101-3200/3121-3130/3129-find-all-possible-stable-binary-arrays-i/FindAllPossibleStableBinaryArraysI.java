public class FindAllPossibleStableBinaryArraysI {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.numberOfStableArrays(3, 3, 2));
  }
}

class Solution {
  public int numberOfStableArrays(int zero, int one, int limit) {
    var MODULO = 1_000_000_007L;
    var data = new long[zero + 1][one + 1][2];

    data[0][0][0] = 1;
    data[0][0][1] = 1;

    for (var i = 0; i <= zero; i++) {
      for (var j = 0; j <= one; j++) {
        for (var k = 1; k <= limit; k++) {
          if (i >= k) {
            data[i][j][0] = (data[i][j][0] + data[i - k][j][1]) % MODULO;
          }

          if (j >= k) {
            data[i][j][1] = (data[i][j][1] + data[i][j - k][0]) % MODULO;
          }
        }
      }
    }

    return (int) ((data[zero][one][0] + data[zero][one][1]) % MODULO);
  }
}
