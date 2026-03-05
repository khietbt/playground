public class MinimumChangesToMakeAlternatingBinaryString {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minOperations("0100"));
  }
}

class Solution {
  public int minOperations(String s) {
    var operations = 0;
    var previous = '0';

    for (var i = 0; i < s.length(); i++) {
      if (s.charAt(i) == previous) {
        operations++;
      }

      previous = previous == '0' ? '1' : '0';
    }

    var minimum = operations;

    operations = 0;
    previous = '1';
    for (var i = 0; i < s.length(); i++) {
      if (s.charAt(i) == previous) {
        operations++;
      }

      previous = previous == '0' ? '1' : '0';
    }

    return Math.min(minimum, operations);
  }
}
