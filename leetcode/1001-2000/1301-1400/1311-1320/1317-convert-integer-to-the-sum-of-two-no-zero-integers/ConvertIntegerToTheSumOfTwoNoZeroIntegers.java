import java.util.Arrays;

public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {

  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(
        Arrays.toString(
            solution.getNoZeroIntegers(2)));

    System.out.println(
        Arrays.toString(
            solution.getNoZeroIntegers(11)));
  }
}

class Solution {
  public int[] getNoZeroIntegers(int n) {
    var answers = new int[2];

    var i = 1;

    while (true) {
      var j = n - i;

      if (String.valueOf(i).indexOf("0") == -1
          && String.valueOf(j).indexOf("0") == -1) {
        answers[0] = i;
        answers[1] = j;

        break;
      }

      i++;
    }

    return answers;
  }
}
