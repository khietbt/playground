public class CountBinarySubstrings {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.countBinarySubstrings("00110011"));
  }
}

class Solution {
  public int countBinarySubstrings(String s) {
    var current = 1;
    var previous = 0;

    var totalBinarySubstrings = 0;

    for (var i = 1; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i - 1)) {
        totalBinarySubstrings += Math.min(current, previous);

        previous = current;
        current = 1;
      } else {
        current++;
      }
    }

    return totalBinarySubstrings + Math.min(current, previous);
  }
}
