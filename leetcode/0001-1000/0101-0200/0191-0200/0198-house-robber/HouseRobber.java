public class HouseRobber {
  public static void main(String[] args) {
    System.out.println(new Solution().rob(new int[] { 2, 7, 9, 6, 4 }));
  }
}

class Solution {
  public int rob(int[] numbers) {
    int previous = 0;
    int current = 0;

    for (int number : numbers) {
      int a = Math.max(previous, current);
      int b = previous + number;

      //
      previous = a;
      current = b;
    }

    return Math.max(previous, current);
  }
}
