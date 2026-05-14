public class SubstringsOfSizeThreeWithDistinctCharacters {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.countGoodSubstrings("aababcabc"));
    System.out.println(solution.countGoodSubstrings("xyzzaz"));
  }
}

class Solution {
  public int countGoodSubstrings(String s) {
    if (s.length() < 3) {
      return 0;
    }

    var totalGoodSubstrings = 0;

    var b = s.charAt(0);
    var c = s.charAt(1);
    var a = ' ';

    for (var i = 2; i < s.length(); i++) {
      a = b;
      b = c;
      c = s.charAt(i);

      if (a != b && b != c && c != a) {
        totalGoodSubstrings++;
      }
    }

    return totalGoodSubstrings;
  }
}
