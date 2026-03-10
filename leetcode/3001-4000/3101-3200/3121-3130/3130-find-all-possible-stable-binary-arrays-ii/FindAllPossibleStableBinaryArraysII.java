public class FindAllPossibleStableBinaryArraysII {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.numberOfStableArrays(425, 581, 287));
  }
}

class Solution {
  public int numberOfStableArrays(int zero, int one, int limit) {
    var MODULO = 1_000_000_007;

    var dp0 = new int[one + 1][zero + 1];
    var dp1 = new int[one + 1][zero + 1];

    for (int i = 1; i <= Math.min(one, limit); i++) {
      dp1[i][0] = 1;
    }

    for (int j = 1; j <= Math.min(zero, limit); j++) {
      dp0[0][j] = 1;
    }

    for (int o = 1; o <= one; o++) {
      for (int z = 1; z <= zero; z++) {
        // if (o == 0 && z == 0) {
        // continue;
        // }

        dp0[o][z] = dp1[o][z - 1];
        dp0[o][z] = (dp0[o][z] + dp0[o][z - 1]) % MODULO;

        if (z - limit - 1 >= 0) {
          dp0[o][z] = (dp0[o][z] - dp1[o][z - limit - 1] + MODULO) % MODULO;
        }

        dp1[o][z] = dp0[o - 1][z];
        dp1[o][z] = (dp1[o][z] + dp1[o - 1][z]) % MODULO;

        if (o - limit - 1 >= 0) {
          dp1[o][z] = (dp1[o][z] - dp0[o - limit - 1][z] + MODULO) % MODULO;
        }
      }
    }

    return (dp0[one][zero] + dp1[one][zero]) % MODULO;
  }
}
