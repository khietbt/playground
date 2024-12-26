import java.util.Arrays;

public class MoveZeroes {
  public static void main(String[] args) {
    int[] numbers = new int[] { 0, 1, 0, 3, 12 };

    new Solution().moveZeroes(numbers);

    System.out.println(Arrays.toString(numbers));
  }
}

class Solution {
  public void moveZeroes(int[] numbers) {
    int j = 0;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] != 0) {
        numbers[j++] = numbers[i];
      }
    }

    for (int i = j; i < numbers.length; i++) {
      numbers[i] = 0;
    }
  }
}
