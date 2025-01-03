import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {
  public static void main(String[] args) {
    System.out.println(new Solution().closeStrings("abc", "bca"));
  }
}

class Solution {
  public boolean closeStrings(String lhs, String rhs) {
    if (lhs.equals(rhs)) {
      return true;
    }

    if (lhs.length() != rhs.length()) {
      return true;
    }

    int[] left = new int[26];
    int[] right = new int[26];

    for (int i = 0; i < lhs.length(); i++) {
      left[lhs.charAt(i) - 'a']++;
    }

    for (int i = 0; i < rhs.length(); i++) {
      right[rhs.charAt(i) - 'a']++;
    }

    for (int i = 0; i < 26; i++) {
      if ((left[i] > 0 && right[i] == 0) || (right[i] > 0 && left[i] == 0)) {
        return false;
      }
    }

    Arrays.sort(left);
    Arrays.sort(right);

    return Arrays.equals(left, right);
  }
}
