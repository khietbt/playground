public class DecodeWays {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.numDecodings("12"));
    System.out.println(solution.numDecodings("226"));
    System.out.println(solution.numDecodings("06"));
    System.out.println(solution.numDecodings("111111111111111111111111111111111111111111111"));
  }
}

class Solution {
  public int numDecodings(String s) {
    var c = 0;

    for (int i = s.length() - 1, p = 1, pp = 0; i >= 0; i--, pp = p, p = c) {
      if (s.charAt(i) == '0') {
        c = 0;
      } else {
        c = p;

        if (i + 1 == s.length()) {
          continue;
        }

        var v = Integer.valueOf(s.substring(i, i + 2));

        if (v > 26) {
          continue;
        }

        c += pp;
      }
    }

    return c;
  }
}
