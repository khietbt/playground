public class HappyNumber {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.isHappy(19));
    System.out.println(solution.isHappy(2));
    System.out.println(solution.isHappy(7));
  }
}

class Solution {
  int square(int n) {
    var sum = 0;

    while (n > 0) {
      var r = n % 10;

      sum += r * r;

      n = n / 10;
    }

    return sum;
  }

  public boolean isHappy(int n) {
    if (n == 1) {
      return true;
    }

    var slow = n;
    var fast = n;

    while (fast != 1 && square(fast) != 1) {
      slow = square(slow);
      fast = square(square(fast));

      if (slow == fast) {
        return false;
      }
    }

    return fast == 1 || square(fast) == 1;
  }
}
