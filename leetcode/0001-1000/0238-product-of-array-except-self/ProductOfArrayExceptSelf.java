import java.util.Arrays;

public class ProductOfArrayExceptSelf {
  public static void main(String[] args) {
    int[] numbers = new int[] {
        1, 2, 3, 4
    };

    System.out.println(Arrays.toString(new Solution().productExceptSelf(numbers)));
  }
}

class Solution {
  public int[] productExceptSelf(int[] numbers) {
    int totalZeros = 0;
    int zeroIndex = 0;
    int product = 1;

    for (int i = 0; i < numbers.length; i++) {
      if (numbers[i] == 0) {
        totalZeros++;
        zeroIndex = i;
        continue;
      }

      product *= numbers[i];
    }

    if (totalZeros > 0) {
      Arrays.fill(numbers, 0);

      if (totalZeros == 1) {
        numbers[zeroIndex] = product;
      }
    } else {
      for (int i = 0; i < numbers.length; i++) {
        numbers[i] = product / numbers[i];
      }
    }

    return numbers;
  }
}
