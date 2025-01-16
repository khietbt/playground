import java.util.Arrays;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
  public static void main(String[] args) {
    System.out.println("001011");
    System.out.println(Arrays.toString(new Solution().minOperations("001011")));
  }
}

class Solution {
  public int[] minOperations(String boxes) {
    int n = boxes.length();
    int[] operations = new int[n];

    for (int i = 1, balls = 0; i < boxes.length(); i++) {
      balls += boxes.charAt(i - 1) - '0';

      operations[i] += operations[i - 1] + balls;
    }

    System.out.println(Arrays.toString(operations));

    for (int i = n - 2, balls = 0, sum = 0; i >= 0; i--) {
      balls += boxes.charAt(i + 1) - '0';

      sum += balls;

      operations[i] += sum;
    }

    return operations;
  }
}
