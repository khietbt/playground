public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.checkOnesSegment("1001"));
    System.out.println(solution.checkOnesSegment("110"));
  }
}

class Solution {
  public boolean checkOnesSegment(String s) {
    var changed = false;

    for (var i = 1; i < s.length(); i++) {
      if (s.charAt(i) != s.charAt(i - 1)) {
        if (changed) {
          return false;
        }

        changed = true;
      }
    }

    return true;
  }
}
