public class FurthestPointFromOrigin {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.furthestDistanceFromOrigin("L_RL__R"));
    System.out.println(solution.furthestDistanceFromOrigin("_______"));
  }
}

class Solution {
  public int furthestDistanceFromOrigin(String moves) {
    var left = 0;
    var right = 0;
    var unspecified = 0;

    for (var i = 0; i < moves.length(); i++) {
      switch (moves.charAt(i)) {
        case 'L':
          left++;
          break;
        case 'R':
          right++;
          break;
        case '_':
          unspecified++;
          break;
      }
    }

    return Math.max(Math.abs(left - right - unspecified), Math.abs(left - right + unspecified));
  }
}
