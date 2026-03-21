public class ValidPerfectSquare {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.isPerfectSquare(16));
    System.out.println(solution.isPerfectSquare(14));
    System.out.println(solution.isPerfectSquare(25));
    System.out.println(solution.isPerfectSquare(35));
  }
}

class Solution {
  public boolean isPerfectSquare(int num) {
    var left = 1;
    var right = num;

    while (left <= right) {
      var middle = left + (right - left) / 2;

      if (middle == num / middle) {
        return true;
      } else if (middle > num / middle) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
      //
    }

    return false;
  }
}
