import java.util.Arrays;

public class FindThePrefixCommonArrayOfTwoArrays {
  public static void main(String[] args) {
    // int[] lhs = new int[] { 1, 3, 2, 4 };
    // int[] rhs = new int[] { 3, 2, 4, 1 };

    // int[] lhs = new int[] { 1, 3, 2, 4 };
    // int[] rhs = new int[] { 3, 1, 2, 4 };
    //
    int[] lhs = new int[] { 1, 2, 3, 4 };
    int[] rhs = new int[] { 1, 2, 3, 4 };

    System.out.println(Arrays.toString(new Solution().findThePrefixCommonArray(lhs, rhs)));
    //
  }
}

class Solution {
  public int[] findThePrefixCommonArray(int[] lhs, int[] rhs) {
    int length = lhs.length;

    if (length == 0) {
      return new int[] {};
    }

    int[] answers = new int[length];

    int[] lefts = new int[length + 1];
    int[] rights = new int[length + 1];

    lefts[lhs[0]] = 1;
    rights[rhs[0]] = 1;

    if (lhs[0] == rhs[0]) {
      answers[0] = 1;
    }

    for (int i = 1; i < length; i++) {
      answers[i] = answers[i - 1];

      lefts[lhs[i]] = 1;

      if (rights[lhs[i]] == 1) {
        answers[i]++;
      }

      rights[rhs[i]] = 1;

      if (lefts[rhs[i]] == 1) {
        answers[i]++;
      }
    }

    return answers;
  }
}
