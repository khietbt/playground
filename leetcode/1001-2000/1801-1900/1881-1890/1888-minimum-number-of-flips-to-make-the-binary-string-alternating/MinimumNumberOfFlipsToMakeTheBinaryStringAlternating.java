public class MinimumNumberOfFlipsToMakeTheBinaryStringAlternating {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minFlips("111000"));
    System.out.println(solution.minFlips("1110"));
  }
}

class Solution {
  public int minFlips(String s) {
    var operations = new int[] { 0, 0 };

    var minimum = Integer.MAX_VALUE;

    for (var i = 0; i < s.length(); i++) {
      operations[(i ^ s.charAt(i)) & 1]++;
    }

    minimum = Math.min(operations[0], operations[1]);

    for (var i = 0; i < s.length(); i++) {
      operations[(i ^ s.charAt(i)) & 1]--;
      operations[((i + s.length()) ^ s.charAt(i)) & 1]++;

      minimum = Math.min(Math.min(operations[0], operations[1]), minimum);
    }

    return minimum;
  }
}
