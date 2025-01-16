import java.util.function.Function;

public class FindLongestSpecialSubstringThatOccursThriceI {
  public static void main(String[] args) {
    // String s = "aaaa";
    String s = "aaababacaaaa";

    System.out.println((new Solution()).maximumLength(s));
  }
}

class Solution {
  public int maximumLength(String s) {
    int left = 0;
    int right = s.length();

    Function<Integer, Boolean> hasSubstringOccuringThrice = (size) -> {
      int[] repeats = new int[26];

      for (int i = 0; i < s.length();) {
        int j = i + 1;

        while (j < s.length() && s.charAt(j) == s.charAt(j - 1)) {
          j++;
        }

        int repeat = j - i - size + 1;

        int index = s.charAt(i) - 'a';

        repeats[index] += Math.max(0, repeat);

        if (repeats[index] >= 3) {
          return true;
        }

        i = j;
      }

      return false;
    };

    while (left < right) {
      int middle = (left + right + 1) / 2;

      if (hasSubstringOccuringThrice.apply(middle)) {
        left = middle;
      } else {
        right = middle - 1;
      }
    }

    return left == 0 ? -1 : left;
  }
}
