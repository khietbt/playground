public class IncreasingTripletSubsequence {
  public static void main(String[] args) {
    System.out.println(new Solution().increasingTriplet(new int[] { 1, 2 }));
  }
}

class Solution {
  public boolean increasingTriplet(int[] numbers) {
    int smallest = Integer.MAX_VALUE;
    int middle = Integer.MAX_VALUE;

    for (int number : numbers) {
      if (number > middle) {
        return true;
      }

      if (number <= smallest) {
        smallest = number;
      } else {
        middle = number;
      }
    }

    return false;
  }
}
