public class LongerContiguousSegmentsOfOnesThanZeros {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.checkZeroOnes("1101"));
    System.out.println(solution.checkZeroOnes("110100010"));
  }
}

class Solution {
  public boolean checkZeroOnes(String s) {
    var longestOnes = 0;
    var longestZeros = 0;
    var current = 1;

    for (var i = 1; i < s.length(); i++) {
      if (s.charAt(i) == s.charAt(i - 1)) {
        current++;
        continue;
      }

      if (s.charAt(i) == '1') {
        longestZeros = Math.max(longestZeros, current);
      } else {
        longestOnes = Math.max(longestOnes, current);
      }

      current = 1;
    }

    if (s.charAt(s.length() - 1) == '0') {
      longestZeros = Math.max(longestZeros, current);
    } else {
      longestOnes = Math.max(longestOnes, current);
    }

    return longestOnes > longestZeros;
  }
}
