public class MinimumDeletionsToMakeStringBalanced {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.minimumDeletions("aababbab"));
    System.out.println(solution.minimumDeletions("bbaaaaabb"));
  }
}

class Solution {
  public int minimumDeletions(String s) {
    var totalDeletion = 0;
    var bBeforeA = 0;

    for (var c : s.toCharArray()) {
      if (c == 'b') {
        bBeforeA++;
      } else if (bBeforeA > 0) {
        bBeforeA--;
        totalDeletion++;
      }
    }

    return totalDeletion;
  }
}
